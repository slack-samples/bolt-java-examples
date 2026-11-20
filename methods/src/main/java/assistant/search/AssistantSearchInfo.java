package assistant.search;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.assistant.search.AssistantSearchInfoRequest;
import com.slack.api.methods.response.asssistant.search.AssistantSearchInfoResponse;
import java.io.IOException;

public class AssistantSearchInfo {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the assistant.search.info method
        AssistantSearchInfoRequest request =
                AssistantSearchInfoRequest.builder().build();
        AssistantSearchInfoResponse response = methods.assistantSearchInfo(request);

        // Inspect the response
        System.out.println(response);
    }
}
