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
                + "\"context_bar_items\":["
                + "{\"key\":\"repo\",\"label\":\"borant/billing\",\"icon\":\"folder\",\"url\":\"https://github.com/borant/billing\"},"
                + "{\"key\":\"branch\",\"label\":\"agent/migrate-cron\",\"icon\":\"branch\",\"url\":\"https://github.com/borant/billing/tree/agent/migrate-cron\"},"
                + "{\"key\":\"pr\",\"label\":\"PR #42 is open\",\"icon\":\"hierarchy\",\"url\":\"https://github.com/borant/billing/pull/42\"},"
                + "{\"key\":\"ci\",\"label\":\"Tests pending\",\"icon\":\"terminal\"}"
                + "]"
                + "}";
        AgentsConversationsSetPropertiesRequest request = AgentsConversationsSetPropertiesRequest.builder()
                .channelId("C9876543210")
                .codeChannelAsString(codeChannel)
                .build();
        AgentsConversationsSetPropertiesResponse response = methods.agentsConversationsSetProperties(request);

        // Inspect the response
        System.out.println(response);
    }
}
