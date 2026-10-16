package acme;

import static acme.Fixtures.context;
import static acme.Fixtures.installer;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slack.api.app_backend.SlackSignature;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.request.RequestHeaders;
import com.slack.api.bolt.request.builtin.BlockActionRequest;
import com.slack.api.bolt.request.builtin.EventRequest;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.service.InstallationService;
import com.slack.api.bolt.service.builtin.FileInstallationService;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class AcmeAppTest {
    private static final String SIGNING_SECRET = "test_signing_secret";
    private static final String REQUEST_AUTH = "apps.user.connection.requestAuth";

    @TempDir
    Path directory;

    private FakeSlackApi slackApi;
    private AcmeAccounts accounts;
    private App app;

    @BeforeEach
    public void setUp() throws Exception {
        slackApi = new FakeSlackApi();
        AppConfig config = AppConfig.builder()
                .clientId("111.222")
                .signingSecret(SIGNING_SECRET)
                .singleTeamBotToken(null)
                .slack(slackApi.slack())
                .build();
        InstallationService installations = new FileInstallationService(config, directory.toString());
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));
        accounts = new AcmeAccounts(installations);
        AcmeProvider provider = new AcmeProvider("https://acme.example/slack/install");
        app = AcmeApp.api(config, installations, new AcmeListeners(slackApi.slack(), accounts, provider));
    }

    @AfterEach
    public void tearDown() {
        slackApi.close();
    }

    @Test
    public void testConnectClicksAreAcknowledged() throws Exception {
        Response response = app.run(blockAction(AcmeProvider.CONNECT_ACTION_ID));

        assertEquals(200, response.getStatusCode());
        assertEquals(List.of(), apiCalls());
    }

    @Test
    public void testDisconnectClicksForgetTheAccount() throws Exception {
        Response response = app.run(blockAction(AcmeProvider.DISCONNECT_ACTION_ID));

        assertEquals(200, response.getStatusCode());
        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
        assertEquals(List.of(REQUEST_AUTH, "views.publish", "auth.revoke"), apiCalls());
    }

    @Test
    public void testAppHomeOpenedPublishesTheHomeView() throws Exception {
        Response response = app.run(event("{\"type\":\"app_home_opened\",\"user\":\"U0ADA\"}"));

        assertEquals(200, response.getStatusCode());
        assertEquals(List.of("views.publish"), apiCalls());
    }

    @Test
    public void testStatusRequestsAreAnswered() throws Exception {
        Response response = app.run(event("{\"type\":\"user_connection_status_requested\",\"user\":\"U0ADA\"}"));

        assertEquals(200, response.getStatusCode());
        assertEquals(
                "connected",
                slackApi.call("apps.user.connection.update").params().get("status"));
    }

    @Test
    public void testRevokedUserTokensAreForgotten() throws Exception {
        Response response = app.run(event("{\"type\":\"tokens_revoked\",\"tokens\":{\"oauth\":[\"U0ADA\"]}}"));

        assertEquals(200, response.getStatusCode());
        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
    }

    private List<String> apiCalls() {
        return slackApi.methods().stream()
                .filter(method -> !method.equals("auth.test"))
                .toList();
    }

    private static BlockActionRequest blockAction(String actionId) {
        String payload = """
            {
              "type": "block_actions",
              "api_app_id": "A0001",
              "team": { "id": "T0001" },
              "user": { "id": "U0ADA", "team_id": "T0001" },
              "trigger_id": "123.456.abc",
              "actions": [
                { "type": "button", "action_id": "%s", "block_id": "acme", "action_ts": "1700000000.000001" }
              ]
            }
            """.formatted(actionId);
        String body = "payload=" + URLEncoder.encode(payload, StandardCharsets.UTF_8);
        return new BlockActionRequest(body, payload, signedHeaders(body));
    }

    private static EventRequest event(String event) {
        String body = """
            {
              "type": "event_callback",
              "api_app_id": "A0001",
              "team_id": "T0001",
              "event": %s,
              "event_id": "Ev0001",
              "event_time": 1700000000
            }
            """.formatted(event);
        return new EventRequest(body, signedHeaders(body));
    }

    private static RequestHeaders signedHeaders(String body) {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String signature = new SlackSignature.Generator(SIGNING_SECRET).generate(timestamp, body);
        return new RequestHeaders(Map.of(
                "X-Slack-Request-Timestamp", List.of(timestamp),
                "X-Slack-Signature", List.of(signature)));
    }
}
