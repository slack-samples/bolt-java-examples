package agents.sessions;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.sessions.AgentsSessionsRenameRequest;
import com.slack.api.methods.response.agents.sessions.AgentsSessionsRenameResponse;
import java.io.IOException;

public class AgentsSessionsRename {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.sessions.rename method
        AgentsSessionsRenameRequest request = AgentsSessionsRenameRequest.builder()
                .channelId("C123ABC456")
                .title("Fix flaky login test")
                .build();
        AgentsSessionsRenameResponse response = methods.agentsSessionsRename(request);

        // Inspect the response
        System.out.println(response);
    }
}
