package apps.managed.permissions;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.apps.managed.permissions.AppsManagedPermissionsSetRequest;
import com.slack.api.methods.response.apps.managed.permissions.AppsManagedPermissionsSetResponse;
import java.io.IOException;

public class AppsManagedPermissionsSet {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the apps.managed.permissions.set method
        AppsManagedPermissionsSetRequest request = AppsManagedPermissionsSetRequest.builder()
                .appId("A0123456789")
                .permissions("everyone")
                .build();
        AppsManagedPermissionsSetResponse response = methods.appsManagedPermissionsSet(request);

        // Inspect the response
        System.out.println(response);
    }
}
