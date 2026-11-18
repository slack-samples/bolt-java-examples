package admin.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.conversations.AdminConversationsUnlinkObjectsRequest;
import com.slack.api.methods.response.admin.conversations.AdminConversationsUnlinkObjectsResponse;
import java.io.IOException;

public class AdminConversationsUnlinkObjects {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.conversations.unlinkObjects method
        AdminConversationsUnlinkObjectsRequest request = AdminConversationsUnlinkObjectsRequest.builder()
                .channel("C0123456789")
                .newName("unlinked-channel")
                .build();
        AdminConversationsUnlinkObjectsResponse response = methods.adminConversationsUnlinkObjects(request);

        // Inspect the response
        System.out.println(response);
    }
}
