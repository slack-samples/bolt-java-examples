package admin.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.conversations.AdminConversationsCreateForObjectsRequest;
import com.slack.api.methods.response.admin.conversations.AdminConversationsCreateForObjectsResponse;
import java.io.IOException;

public class AdminConversationsCreateForObjects {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.conversations.createForObjects method
        AdminConversationsCreateForObjectsRequest request = AdminConversationsCreateForObjectsRequest.builder()
                .objectId("0019000000DmehKAAR")
                .salesforceOrgId("00DGC00000024hsuWY")
                .inviteObjectTeam(true)
                .build();
        AdminConversationsCreateForObjectsResponse response = methods.adminConversationsCreateForObjects(request);

        // Inspect the response
        System.out.println(response);
    }
}
