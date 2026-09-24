package agents.conversations;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.agents.conversations.AgentsConversationsSetViewRequest;
import com.slack.api.methods.response.agents.conversations.AgentsConversationsSetViewResponse;
import java.io.IOException;

public class AgentsConversationsSetView {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the agents.conversations.setView method
        AgentsConversationsSetViewRequest request = AgentsConversationsSetViewRequest.builder()
                .channelId("C123ABC456")
                .type("diff")
                .content("diff --git a/cron.py b/cron.py\n--- a/cron.py\n+++ b/cron.py\n@@ ...")
                .baseBranch("main")
                .headBranch("agent/migrate-cron")
                .build();
        AgentsConversationsSetViewResponse response = methods.agentsConversationsSetView(request);

        // Inspect the response
        System.out.println(response);
    }
}
