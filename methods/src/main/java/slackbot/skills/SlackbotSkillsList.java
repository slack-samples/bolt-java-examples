package slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.SlackbotSkillsListRequest;
import com.slack.api.methods.response.slackbot.skills.SlackbotSkillsListResponse;
import java.io.IOException;

public class SlackbotSkillsList {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.list method
        SlackbotSkillsListRequest request = SlackbotSkillsListRequest.builder()
                .filter("owned")
                .category("productivity")
                .build();
        SlackbotSkillsListResponse response = methods.slackbotSkillsList(request);

        // Inspect the response
        System.out.println(response);
    }
}
