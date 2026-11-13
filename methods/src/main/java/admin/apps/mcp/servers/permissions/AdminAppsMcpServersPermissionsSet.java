package admin.apps.mcp.servers.permissions;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.apps.mcp.servers.permissions.AdminAppsMcpServersPermissionsSetRequest;
import com.slack.api.methods.response.admin.apps.mcp.servers.permissions.AdminAppsMcpServersPermissionsSetResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminAppsMcpServersPermissionsSet {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.apps.mcp.servers.permissions.set method
        AdminAppsMcpServersPermissionsSetRequest request = AdminAppsMcpServersPermissionsSetRequest.builder()
                .appId("A0123ABCD")
                .serverId("Amcp0456EFGH")
                .permissionType("named_entities")
                .userIds(Arrays.asList("U0123ABCD"))
                .usergroupIds(Arrays.asList("S0123ABCD"))
                .build();
        AdminAppsMcpServersPermissionsSetResponse response = methods.adminAppsMcpServersPermissionsSet(request);

        // Inspect the response
        System.out.println(response);
    }
}
