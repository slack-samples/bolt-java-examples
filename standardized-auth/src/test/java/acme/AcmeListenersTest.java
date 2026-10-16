package acme;

import static acme.Fixtures.context;
import static acme.Fixtures.installer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import acme.AcmeProvider.Connection;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.service.InstallationService;
import com.slack.api.bolt.service.builtin.FileInstallationService;
import com.slack.api.bolt.service.builtin.oauth.OAuthV2SuccessPersistenceCallback;
import com.slack.api.methods.MethodsClient;
import com.slack.api.util.json.GsonFactory;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class AcmeListenersTest {
    private static final Optional<Connection> ADA = Optional.of(new Connection("@ada", "Acme Corp"));
    private static final String REQUEST_AUTH = "apps.user.connection.requestAuth";

    @TempDir
    Path directory;

    private final AcmeProvider provider = new AcmeProvider("https://acme.example/slack/install");
    private final AppConfig config = AppConfig.builder().clientId("111.222").build();
    private FakeSlackApi slackApi;
    private InstallationService installations;
    private AcmeAccounts accounts;
    private AcmeListeners listeners;
    private MethodsClient client;

    @BeforeEach
    public void setUp() throws Exception {
        slackApi = new FakeSlackApi();
        installations = new FileInstallationService(config, directory.toString());
        accounts = new AcmeAccounts(installations);
        listeners = new AcmeListeners(slackApi.slack(), accounts, provider);
        client = slackApi.slack().methods("xoxb-test-bot");
    }

    @AfterEach
    public void tearDown() {
        slackApi.close();
    }

    @Test
    public void testReportConnectedRecordsTheConnectionThenShowsTheSuccessPage() {
        Response response = new Response();

        listeners.reportConnected(OAuthV2SuccessPersistenceCallback.Arguments.builder()
                .appConfig(config)
                .pageRenderer(config.getOAuthRedirectUriPageRenderer())
                .installer(installer("U0ADA", "xoxp-test-ada"))
                .response(response)
                .build());

        assertEquals(List.of("auth.test", REQUEST_AUTH, "views.publish"), slackApi.methods());
        assertEquals("xoxp-test-ada", slackApi.call("auth.test").token());
        assertEquals("xoxb-test-bot", slackApi.call(REQUEST_AUTH).token());
        assertEquals("U0ADA", slackApi.call(REQUEST_AUTH).params().get("user_id"));
        assertEquals(json(provider.primaryProvider(ADA)), param(REQUEST_AUTH, "primary_provider"));
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testPublishHomeShowsAConnectedAccount() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.publishHome(client, context(), "U0ADA");

        assertEquals(List.of("auth.test", "views.publish"), slackApi.methods());
        assertEquals("U0ADA", slackApi.call("views.publish").params().get("user_id"));
        assertEquals(json(provider.homeView(ADA)), param("views.publish", "view"));
    }

    @Test
    public void testPublishHomeOffersToConnectUsersWithoutAnAccount() throws Exception {
        listeners.publishHome(client, context(), "U0ADA");

        assertEquals(List.of("views.publish"), slackApi.methods());
        assertEquals(json(provider.homeView(Optional.empty())), param("views.publish", "view"));
    }

    @Test
    public void testDisconnectForgetsReportsThenRevokes() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.disconnect(client, context(), "U0ADA");

        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
        assertEquals(List.of(REQUEST_AUTH, "views.publish", "auth.revoke"), slackApi.methods());
        assertEquals(json(provider.primaryProvider(Optional.empty())), param(REQUEST_AUTH, "primary_provider"));
        assertEquals("xoxp-test-ada", slackApi.call("auth.revoke").token());
    }

    @Test
    public void testDisconnectingWithoutAnAccountStillReportsDisconnected() throws Exception {
        listeners.disconnect(client, context(), "U0ADA");

        assertEquals(List.of(REQUEST_AUTH, "views.publish"), slackApi.methods());
    }

    @Test
    public void testAnswerStatusRequestReportsConnectedUsers() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.answerStatusRequest(client, context(), "U0ADA");

        assertEquals(
                "connected",
                slackApi.call("apps.user.connection.update").params().get("status"));
    }

    @Test
    public void testAnswerStatusRequestReportsUsersWithoutAnAccountAsDisconnected() throws Exception {
        listeners.answerStatusRequest(client, context(), "U0ADA");

        assertEquals(
                "disconnected",
                slackApi.call("apps.user.connection.update").params().get("status"));
    }

    @Test
    public void testForgetRevokedUsersReportsThemDisconnected() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.forgetRevokedUsers(client, context(), List.of("U0ADA"));

        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
        assertEquals(List.of(REQUEST_AUTH, "views.publish"), slackApi.methods());
    }

    @Test
    public void testForgetRevokedUsersIgnoresRevokedBotTokens() throws Exception {
        listeners.forgetRevokedUsers(client, context(), null);

        assertEquals(List.of(), slackApi.methods());
    }

    @Test
    public void testUserConnectionConnectOpensTheAuthModal() throws Exception {
        listeners.handleUserConnection(client, context(), "connect", "U0ADA", "123.456.abc");

        assertEquals(List.of(REQUEST_AUTH), slackApi.methods());
        assertEquals("123.456.abc", slackApi.call(REQUEST_AUTH).params().get("trigger_id"));
        assertEquals(json(provider.primaryProvider(Optional.empty())), param(REQUEST_AUTH, "primary_provider"));
    }

    @Test
    public void testUserConnectionConnectShowsAnExistingConnection() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.handleUserConnection(client, context(), "connect", "U0ADA", "123.456.abc");

        assertEquals(json(provider.primaryProvider(ADA)), param(REQUEST_AUTH, "primary_provider"));
    }

    @Test
    public void testUserConnectionDisconnectForgetsTheAccount() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        listeners.handleUserConnection(client, context(), "disconnect", "U0ADA", null);

        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
        assertTrue(slackApi.methods().contains("auth.revoke"));
    }

    @Test
    public void testUserConnectionWithAnUnknownSubtypeCallsNothing() throws Exception {
        listeners.handleUserConnection(client, context(), "reconnect", "U0ADA", null);

        assertEquals(List.of(), slackApi.methods());
    }

    private JsonElement param(String method, String name) {
        return JsonParser.parseString(slackApi.call(method).params().get(name));
    }

    private static JsonElement json(Object value) {
        return JsonParser.parseString(GsonFactory.createSnakeCase().toJson(value));
    }
}
