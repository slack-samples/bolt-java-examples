package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetCommandsRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetCommandsResponse;
import java.io.IOException;

public class AgentsConversationsSetCommands {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setCommands method
        // The commands array is passed as a JSON-encoded string until the command item shape stabilizes
        String commands = "["
                + "{\"name\":\"test\",\"description\":\"Run the test suite\"},"
                + "{\"name\":\"diff\",\"description\":\"Show the current diff\"}"
                + "]";
        AgentsConversationsSetCommandsRequest request = AgentsConversationsSetCommandsRequest.builder()
                .channelId("C123ABC456")
                .commandsAsString(commands)
                .build();
        AgentsConversationsSetCommandsResponse response = methods.agentsConversationsSetCommands(request);

        // Inspect the response
        System.out.println(response);
    }
}
