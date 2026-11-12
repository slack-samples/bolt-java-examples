package slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.SlackbotSkillsDeleteRequest;
import com.slack.api.methods.response.slackbot.skills.SlackbotSkillsDeleteResponse;
import java.io.IOException;

public class SlackbotSkillsDelete {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.delete method
        SlackbotSkillsDeleteRequest request =
                SlackbotSkillsDeleteRequest.builder().skillId("F0123ABCD").build();
        SlackbotSkillsDeleteResponse response = methods.slackbotSkillsDelete(request);

        // Inspect the response
        System.out.println(response);
    }
}
