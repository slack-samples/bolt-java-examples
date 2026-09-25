package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetViewRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetViewResponse;
import java.io.IOException;

public class AgentsConversationsSetView {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setView method
        // The csp object is passed as a JSON-encoded string until its shape stabilizes
        String csp = "{\"resource_domains\":[\"https://cdn.jsdelivr.net\"]}";
        AgentsConversationsSetViewRequest request = AgentsConversationsSetViewRequest.builder()
                .channelId("C9876543210")
                .viewKey("reports/coverage.html")
                .name("Coverage")
                .content("<!doctype html><html><head>…</head><body>…</body></html>")
                .cspAsString(csp)
                .build();
        AgentsConversationsSetViewResponse response = methods.agentsConversationsSetView(request);

        // Inspect the response
        System.out.println(response);
    }
}
