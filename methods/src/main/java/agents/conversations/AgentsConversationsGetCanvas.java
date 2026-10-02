package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsGetCanvasRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsGetCanvasResponse;
import java.io.IOException;

public class AgentsConversationsGetCanvas {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.getCanvas method
        AgentsConversationsGetCanvasRequest request = AgentsConversationsGetCanvasRequest.builder()
                .channel("C9876543210")
                .canvasId("F1234567890")
                .includeResolved(false)
                .build();
        AgentsConversationsGetCanvasResponse response = methods.agentsConversationsGetCanvas(request);

        // Inspect the response
        System.out.println(response);
    }
}
