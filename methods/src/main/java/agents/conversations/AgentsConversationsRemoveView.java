package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsRemoveViewRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsRemoveViewResponse;
import java.io.IOException;

public class AgentsConversationsRemoveView {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.removeView method
        AgentsConversationsRemoveViewRequest request = AgentsConversationsRemoveViewRequest.builder()
                .channelId("C9876543210")
                .viewKey("reports/coverage.html")
                .build();
        AgentsConversationsRemoveViewResponse response = methods.agentsConversationsRemoveView(request);

        // Inspect the response
        System.out.println(response);
    }
}
