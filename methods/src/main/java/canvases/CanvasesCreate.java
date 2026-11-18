package canvases;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.canvases.CanvasesCreateRequest;
import com.slack.api.methods.response.canvases.CanvasesCreateResponse;
import com.slack.api.model.canvas.CanvasDocumentContent;
import java.io.IOException;

public class CanvasesCreate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the canvases.create method
        CanvasesCreateRequest request = CanvasesCreateRequest.builder()
                .title("Your Brilliant Title")
                .documentContent(CanvasDocumentContent.builder()
                        .type("markdown")
                        .markdown("> standalone canvas!")
                        .build())
                .build();
        CanvasesCreateResponse response = methods.canvasesCreate(request);

        // Inspect the response
        System.out.println(response);
    }
}
