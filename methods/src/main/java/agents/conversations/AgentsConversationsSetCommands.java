package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetCommandsRequest;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetCommandsRequest.Command;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetCommandsResponse;
import java.io.IOException;
import java.util.List;

public class AgentsConversationsSetCommands {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setCommands method
        AgentsConversationsSetCommandsRequest request = AgentsConversationsSetCommandsRequest.builder()
                .channelId("C9876543210")
                .commands(List.of(
                        Command.builder()
                                .name("create-pr")
                                .description("Open a pull request for the current branch")
                                .argumentHint("[title]")
                                .build(),
                        Command.builder()
                                .name("run-tests")
                                .description("Run the test suite and report back")
                                .build(),
                        Command.builder()
                                .name("summarize")
                                .description("Post a summary of the work so far")
                                .build()))
                .build();
        AgentsConversationsSetCommandsResponse response = methods.agentsConversationsSetCommands(request);

        // Inspect the response
        System.out.println(response);
    }
}
