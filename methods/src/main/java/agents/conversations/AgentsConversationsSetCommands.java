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
                + "{\"name\":\"create-pr\",\"description\":\"Open a pull request for the current branch\",\"argument_hint\":\"[title]\"},"
                + "{\"name\":\"run-tests\",\"description\":\"Run the test suite and report back\"},"
                + "{\"name\":\"summarize\",\"description\":\"Post a summary of the work so far\"}"
                + "]";
        AgentsConversationsSetCommandsRequest request = AgentsConversationsSetCommandsRequest.builder()
                .channelId("C9876543210")
                .commandsAsString(commands)
                .build();
        AgentsConversationsSetCommandsResponse response = methods.agentsConversationsSetCommands(request);

        // Inspect the response
        System.out.println(response);
    }
}
