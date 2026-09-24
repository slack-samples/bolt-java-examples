package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetPropertiesRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetPropertiesResponse;
import java.io.IOException;

public class AgentsConversationsSetProperties {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setProperties method
        // The code_channel object is passed as a JSON-encoded string until its shape stabilizes
        String codeChannel = "{"
                + "\"context_bar_items\":[{"
                + "\"key\":\"repo\","
                + "\"label\":\"acme/billing\","
                + "\"icon\":\"folder\","
                + "\"url\":\"https://github.com/acme/billing\""
                + "}]"
                + "}";
        AgentsConversationsSetPropertiesRequest request = AgentsConversationsSetPropertiesRequest.builder()
                .channelId("C123ABC456")
                .codeChannelAsString(codeChannel)
                .build();
        AgentsConversationsSetPropertiesResponse response = methods.agentsConversationsSetProperties(request);

        // Inspect the response
        System.out.println(response);
    }
}
