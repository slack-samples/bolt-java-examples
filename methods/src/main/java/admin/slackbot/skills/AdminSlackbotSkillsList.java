package admin.slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.admin.slackbot.skills.AdminSlackbotSkillsListRequest;
import com.slack.api.methods.response.admin.slackbot.skills.AdminSlackbotSkillsListResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminSlackbotSkillsList {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the admin.slackbot.skills.list method
        AdminSlackbotSkillsListRequest request = AdminSlackbotSkillsListRequest.builder()
                .category("productivity")
                .creatorIds(Arrays.asList("U0123ABCD"))
                .build();
        AdminSlackbotSkillsListResponse response = methods.adminSlackbotSkillsList(request);

        // Inspect the response
        System.out.println(response);
    }
}
