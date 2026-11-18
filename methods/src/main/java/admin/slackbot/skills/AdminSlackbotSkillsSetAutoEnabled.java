package admin.slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.slackbot.skills.AdminSlackbotSkillsSetAutoEnabledRequest;
import com.slack.api.methods.response.admin.slackbot.skills.AdminSlackbotSkillsSetAutoEnabledResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminSlackbotSkillsSetAutoEnabled {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.slackbot.skills.setAutoEnabled method
        AdminSlackbotSkillsSetAutoEnabledRequest request = AdminSlackbotSkillsSetAutoEnabledRequest.builder()
                .skillId("F0123ABCD")
                .permissionType("named_entities")
                .usergroupIds(Arrays.asList("S0123ABCD"))
                .build();
        AdminSlackbotSkillsSetAutoEnabledResponse response = methods.adminSlackbotSkillsSetAutoEnabled(request);

        // Inspect the response
        System.out.println(response);
    }
}
