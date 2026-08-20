package agents.sessions;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.sessions.AgentsSessionsSetStatusRequest;
import com.slack.api.methods.response.agents.sessions.AgentsSessionsSetStatusResponse;
import java.io.IOException;

public class AgentsSessionsSetStatus {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.sessions.setStatus method
        AgentsSessionsSetStatusRequest request = AgentsSessionsSetStatusRequest.builder()
                .channelId("C123ABC456")
                .status("processing")
                .build();
        AgentsSessionsSetStatusResponse response = methods.agentsSessionsSetStatus(request);

        // Inspect the response
        System.out.println(response);
    }
}
