package chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChatPostMessageTest {

    MockWebServer server;
    Slack slack;

    @BeforeEach
    public void setup() throws Exception {
        server = new MockWebServer();
        server.start();
        SlackConfig config = new SlackConfig();
        config.setMethodsEndpointUrlPrefix(server.url("/api/").toString());
        slack = Slack.getInstance(config);
    }

    @AfterEach
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void sends() throws Exception {
        server.enqueue(new MockResponse().setBody("{\"ok\":true}"));

        ChatPostMessageResponse response = ChatPostMessage.example01(slack);
        assertTrue(response.isOk());

        RecordedRequest request = server.takeRequest();
        assertEquals("/api/chat.postMessage", request.getPath());

        String body = URLDecoder.decode(request.getBody().readUtf8(), StandardCharsets.UTF_8);
        assertTrue(body.contains("channel=C123ABC456"));
        assertTrue(body.contains("text=Here's a message for you"));
    }
}
