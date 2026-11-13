package admin.apps.mcp.servers.permissions;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.apps.mcp.servers.permissions.AdminAppsMcpServersPermissionsListRequest;
import com.slack.api.methods.response.admin.apps.mcp.servers.permissions.AdminAppsMcpServersPermissionsListResponse;
import java.io.IOException;

public class AdminAppsMcpServersPermissionsList {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.apps.mcp.servers.permissions.list method
        AdminAppsMcpServersPermissionsListRequest request = AdminAppsMcpServersPermissionsListRequest.builder()
                .appId("A0000000001")
                .build();
        AdminAppsMcpServersPermissionsListResponse response = methods.adminAppsMcpServersPermissionsList(request);

        // Inspect the response
        System.out.println(response);
    }
}
