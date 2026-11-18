package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetCanvasContentRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetCanvasContentResponse;
import java.io.IOException;

public class AgentsConversationsSetCanvasContent {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setCanvasContent method
        AgentsConversationsSetCanvasContentRequest request = AgentsConversationsSetCanvasContentRequest.builder()
                .channel("C9876543210")
                .canvasId("F1234567890")
                .content("# Migration plan\n\n1. Inventory cron jobs\n2. Port billing jobs last\n")
                .build();
        AgentsConversationsSetCanvasContentResponse response = methods.agentsConversationsSetCanvasContent(request);

        // Inspect the response
        System.out.println(response);
    }
}
