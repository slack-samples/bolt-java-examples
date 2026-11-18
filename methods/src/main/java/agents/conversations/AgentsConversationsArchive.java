package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsArchiveRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsArchiveResponse;
import java.io.IOException;

public class AgentsConversationsArchive {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.archive method
        AgentsConversationsArchiveRequest request = AgentsConversationsArchiveRequest.builder()
                .channelId("C9876543210")
                .summaryMessageTs("1717182000.456789")
                .build();
        AgentsConversationsArchiveResponse response = methods.agentsConversationsArchive(request);

        // Inspect the response
        System.out.println(response);
    }
}
