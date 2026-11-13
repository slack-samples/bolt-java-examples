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
                .appId("A0000000001")
                .serverId("Amcp0000000001")
                .permissionType("named_entities")
                .userIds(Arrays.asList("U00000001", "U00000002"))
                .usergroupIds(Arrays.asList("S00000001", "S00000002"))
                .build();
        AdminAppsMcpServersPermissionsSetResponse response = methods.adminAppsMcpServersPermissionsSet(request);

        // Inspect the response
        System.out.println(response);
    }
}
