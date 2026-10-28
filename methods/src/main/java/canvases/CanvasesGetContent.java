package canvases;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.canvases.CanvasesGetContentRequest;
import com.slack.api.methods.response.canvases.CanvasesGetContentResponse;
import java.io.IOException;

public class CanvasesGetContent {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the canvases.getContent method
        CanvasesGetContentRequest request = CanvasesGetContentRequest.builder()
                .canvasId("F1234567890")
                .contentType("markdown")
                .build();
        CanvasesGetContentResponse response = methods.canvasesGetContent(request);

        // Inspect the response
        System.out.println(response);
    }
}
