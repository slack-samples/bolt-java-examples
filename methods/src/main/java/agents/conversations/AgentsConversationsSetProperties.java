package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetPropertiesRequest;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetPropertiesRequest.CodeChannel;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetPropertiesRequest.ContextBarItem;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetPropertiesResponse;
import java.io.IOException;
import java.util.List;

public class AgentsConversationsSetProperties {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setProperties method
        AgentsConversationsSetPropertiesRequest request = AgentsConversationsSetPropertiesRequest.builder()
                .channelId("C9876543210")
                .codeChannel(CodeChannel.builder()
                        .contextBarItems(List.of(
                                ContextBarItem.builder()
                                        .key("repo")
                                        .label("borant/billing")
                                        .icon("folder")
                                        .url("https://github.com/borant/billing")
                                        .build(),
                                ContextBarItem.builder()
                                        .key("branch")
                                        .label("agent/migrate-cron")
                                        .icon("branch")
                                        .url("https://github.com/borant/billing/tree/agent/migrate-cron")
                                        .build(),
                                ContextBarItem.builder()
                                        .key("pr")
                                        .label("PR #42 is open")
                                        .icon("hierarchy")
                                        .url("https://github.com/borant/billing/pull/42")
                                        .build(),
                                ContextBarItem.builder()
                                        .key("ci")
                                        .label("Tests pending")
                                        .icon("terminal")
                                        .build()))
                        .build())
                .build();
        AgentsConversationsSetPropertiesResponse response = methods.agentsConversationsSetProperties(request);

        // Inspect the response
        System.out.println(response);
    }
}
