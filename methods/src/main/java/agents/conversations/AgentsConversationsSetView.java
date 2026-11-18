package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetViewRequest;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetViewRequest.Csp;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetViewResponse;
import java.io.IOException;
import java.util.List;

public class AgentsConversationsSetView {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setView method
        AgentsConversationsSetViewRequest request = AgentsConversationsSetViewRequest.builder()
                .channelId("C9876543210")
                .viewKey("reports/coverage.html")
                .name("Coverage")
                .content("<!doctype html><html><head>…</head><body>…</body></html>")
                .csp(Csp.builder()
                        .resourceDomains(List.of("https://cdn.jsdelivr.net"))
                        .build())
                .build();
        AgentsConversationsSetViewResponse response = methods.agentsConversationsSetView(request);

        // Inspect the response
        System.out.println(response);
    }
}
