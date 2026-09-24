package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsListViewsRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsListViewsResponse;
import java.io.IOException;

public class AgentsConversationsListViews {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.listViews method
        AgentsConversationsListViewsRequest request = AgentsConversationsListViewsRequest.builder()
                .channelId("C123ABC456")
                .build();
        AgentsConversationsListViewsResponse response = methods.agentsConversationsListViews(request);

        // Inspect the response
        System.out.println(response);
    }
}
