package apps.icon;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.apps.icon.AppsIconSetRequest;
import com.slack.api.methods.response.apps.icon.AppsIconSetResponse;
import java.io.IOException;

public class AppsIconSet {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the apps.icon.set method
        AppsIconSetRequest request = AppsIconSetRequest.builder()
                .appId("A0123456789")
                .url("https://example.com/icon.png")
                .build();
        AppsIconSetResponse response = methods.appsIconSet(request);

        // Inspect the response
        System.out.println(response);
    }
}
