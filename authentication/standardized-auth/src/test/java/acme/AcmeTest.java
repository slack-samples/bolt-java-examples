package acme;

import static acme.Acme.homeView;
import static acme.Acme.provider;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest.PrimaryProvider;
import com.slack.api.model.view.View;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcmeTest {
    private TempConnections connections;

    @BeforeEach
    public void setUp() throws Exception {
        connections = new TempConnections();
    }

    @AfterEach
    public void tearDown() throws Exception {
        connections.close();
    }

    @Test
    public void testDisconnectedProviderOffersToConnect() {
        String expected = """
            {
              "value": "acme",
              "name": { "type": "plain_text", "text": "Acme account" },
              "description": {
                "type": "plain_text",
                "text": "Order rocket skates, anvils, and giant magnets without leaving Slack."
              },
              "is_connected": false
            }
            """;

        assertEquals(JsonParser.parseString(expected), json(provider("U0ADA")));
    }

    @Test
    public void testConnectedProviderNamesTheSlackUser() {
        Connections.connect("U0ADA");

        PrimaryProvider acme = provider("U0ADA");

        assertTrue(acme.getIsConnected());
        assertEquals(
                JsonParser.parseString("{\"type\":\"plain_text\",\"text\":\"U0ADA\"}"),
                json(acme.getConnectedIdentity()));
    }

    @Test
    public void testHomeViewRendersTheProviderAsAnAuthProviderBlock() {
        PrimaryProvider acme = provider("U0ADA");

        View view = homeView(acme);

        JsonObject block =
                json(view.getBlocks().get(view.getBlocks().size() - 1)).getAsJsonObject();
        assertEquals("home", view.getType());
        assertEquals("auth_provider", block.remove("type").getAsString());
        assertEquals(json(acme), block);
    }

    private static JsonElement json(Object value) {
        return JsonParser.parseString(GsonFactory.createSnakeCase().toJson(value));
    }
}
