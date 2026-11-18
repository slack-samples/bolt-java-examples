package admin.apps.mcp.servers;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.apps.mcp.servers.AdminAppsMcpServersListRequest;
import com.slack.api.methods.response.admin.apps.mcp.servers.AdminAppsMcpServersListResponse;
import java.io.IOException;

public class AdminAppsMcpServersList {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.apps.mcp.servers.list method
        AdminAppsMcpServersListRequest request =
                AdminAppsMcpServersListRequest.builder().build();
        AdminAppsMcpServersListResponse response = methods.adminAppsMcpServersList(request);

        // Inspect the response
        System.out.println(response);
    }
}
