package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import acme.AcmeProvider.Connection;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.view.View;
import com.slack.api.util.json.GsonFactory;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class AcmeProviderTest {
    private static final String AUTH_URL = "https://acme.example/slack/install";
    private static final Optional<Connection> ADA = Optional.of(new Connection("@ada", "Acme Corp"));

    private final AcmeProvider provider = new AcmeProvider(AUTH_URL);

    @Test
    public void testActionIdsFollowTheProviderValue() {
        assertEquals("auth_provider_connect_acme", AcmeProvider.CONNECT_ACTION_ID);
        assertEquals("auth_provider_disconnect_acme", AcmeProvider.DISCONNECT_ACTION_ID);
    }

    @Test
    public void testDisconnectedProviderOffersTheAcmeSignIn() {
        String expected = """
            {
              "value": "acme",
              "name": { "type": "plain_text", "text": "Acme account" },
              "description": {
                "type": "plain_text",
                "text": "Order rocket skates, anvils, and giant magnets without leaving Slack."
              },
              "auth_url": "https://acme.example/slack/install",
              "is_connected": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), json(provider.primaryProvider(Optional.empty())));
    }

    @Test
    public void testConnectedProviderNamesTheConnectedAccount() {
        JsonObject connected = json(provider.primaryProvider(ADA)).getAsJsonObject();

        assertEquals(true, connected.get("is_connected").getAsBoolean());
        assertEquals(
                JsonParser.parseString("{\"type\":\"plain_text\",\"text\":\"@ada\"}"),
                connected.get("connected_identity"));
        assertEquals(
                JsonParser.parseString("{\"type\":\"plain_text\",\"text\":\"Acme Corp\"}"),
                connected.get("connected_context"));
    }

    @Test
    public void testBlockMatchesThePrimaryProvider() {
        JsonObject block = json(provider.block(ADA)).getAsJsonObject();

        assertEquals("auth_provider", block.remove("type").getAsString());
        assertEquals(json(provider.primaryProvider(ADA)), block);
    }

    @Test
    public void testHomeViewRendersTheProviderAsAnAuthProviderBlock() {
        View view = provider.homeView(Optional.empty());

        assertEquals("home", view.getType());
        assertEquals(
                json(provider.block(Optional.empty())), json(view.getBlocks().get(1)));
    }

    @Test
    public void testHomeViewWelcomesUsersWhoAreNotConnected() {
        assertEquals(AcmeProvider.WELCOME_GREETING, greeting(provider.homeView(Optional.empty())));
    }

    @Test
    public void testHomeViewCelebratesUsersWhoAreConnected() {
        assertEquals(AcmeProvider.CONNECTED_GREETING, greeting(provider.homeView(ADA)));
    }

    private static String greeting(View view) {
        return ((SectionBlock) view.getBlocks().get(0)).getText().getText();
    }

    private static com.google.gson.JsonElement json(Object value) {
        return JsonParser.parseString(GsonFactory.createSnakeCase().toJson(value));
    }
}
