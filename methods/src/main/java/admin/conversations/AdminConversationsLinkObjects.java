package admin.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.conversations.AdminConversationsLinkObjectsRequest;
import com.slack.api.methods.response.admin.conversations.AdminConversationsLinkObjectsResponse;
import java.io.IOException;

public class AdminConversationsLinkObjects {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.conversations.linkObjects method
        AdminConversationsLinkObjectsRequest request = AdminConversationsLinkObjectsRequest.builder()
                .channel("C0123456789")
                .recordId("0019000000DmehKAAR")
                .salesforceOrgId("00DGC00000024hsuWY")
                .build();
        AdminConversationsLinkObjectsResponse response = methods.adminConversationsLinkObjects(request);

        // Inspect the response
        System.out.println(response);
    }
}
