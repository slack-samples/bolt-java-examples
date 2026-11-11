package slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.SlackbotSkillsUpdateRequest;
import com.slack.api.methods.response.slackbot.skills.SlackbotSkillsUpdateResponse;
import com.slack.api.model.slackbot.SkillMcpServer;
import java.io.IOException;
import java.util.Arrays;

public class SlackbotSkillsUpdate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.update method
        SlackbotSkillsUpdateRequest request = SlackbotSkillsUpdateRequest.builder()
                .category("productivity")
                .description("Reviews information from Slack and your calendar to suggest priorities for the day.")
                .displayName("Daily priorities")
                .examplePrompt("Run {skill} for today")
                .instructions("# Purpose\nSuggest the three most important things to work on today.")
                .mcpServers(Arrays.asList(SkillMcpServer.builder()
                        .appId("A0123ABCD")
                        .serverId("Amcp0456EFGH")
                        .serviceType("app")
                        .build()))
                .skillId("F0123ABCD")
                .build();
        SlackbotSkillsUpdateResponse response = methods.slackbotSkillsUpdate(request);

        // Inspect the response
        System.out.println(response);
    }
}
