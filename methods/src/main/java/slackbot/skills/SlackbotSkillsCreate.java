package slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.SlackbotSkillsCreateRequest;
import com.slack.api.methods.response.slackbot.skills.SlackbotSkillsCreateResponse;
import java.io.IOException;
import java.util.Arrays;

public class SlackbotSkillsCreate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.create method
        SlackbotSkillsCreateRequest request = SlackbotSkillsCreateRequest.builder()
                .displayName("Daily priorities")
                .instructions("# Purpose\nSuggest the three most important things to work on today.")
                .description("Reviews information from Slack and your calendar to suggest priorities for the day.")
                .category("productivity")
                .examplePrompt("Run {skill} for today")
                .mcpServers(Arrays.asList(SlackbotSkillsCreateRequest.McpServer.builder()
                        .serviceType("app")
                        .appId("A0123ABCD")
                        .serverId("Amcp0456EFGH")
                        .build()))
                .build();
        SlackbotSkillsCreateResponse response = methods.slackbotSkillsCreate(request);

        // Inspect the response
        System.out.println(response);
    }
}
