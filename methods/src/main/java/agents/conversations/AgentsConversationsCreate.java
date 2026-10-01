package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsCreateRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsCreateResponse;
import java.io.IOException;

public class AgentsConversationsCreate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.create method
        AgentsConversationsCreateRequest request = AgentsConversationsCreateRequest.builder()
                .name("Migrate billing cron to Temporal")
                .sessionId("ses_8675309")
                .originChannelId("C0123456789")
                .originMessageTs("1717171717.123456")
                .build();
        AgentsConversationsCreateResponse response = methods.agentsConversationsCreate(request);

        // Inspect the response
        System.out.println(response);
    }
}
