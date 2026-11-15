package admin.slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.slackbot.skills.AdminSlackbotSkillsPublishRequest;
import com.slack.api.methods.response.admin.slackbot.skills.AdminSlackbotSkillsPublishResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminSlackbotSkillsPublish {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.slackbot.skills.publish method
        AdminSlackbotSkillsPublishRequest request = AdminSlackbotSkillsPublishRequest.builder()
                .skillIds(Arrays.asList("F0123ABCD"))
                .build();
        AdminSlackbotSkillsPublishResponse response = methods.adminSlackbotSkillsPublish(request);

        // Inspect the response
        System.out.println(response);
    }
}
