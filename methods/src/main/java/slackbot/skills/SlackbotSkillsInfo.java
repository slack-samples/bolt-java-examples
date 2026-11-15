package slackbot.skills;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.SlackbotSkillsInfoRequest;
import com.slack.api.methods.response.slackbot.skills.SlackbotSkillsInfoResponse;
import java.io.IOException;

public class SlackbotSkillsInfo {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.info method
        SlackbotSkillsInfoRequest request =
                SlackbotSkillsInfoRequest.builder().skillId("F0123ABCD").build();
        SlackbotSkillsInfoResponse response = methods.slackbotSkillsInfo(request);

        // Inspect the response
        System.out.println(response);
    }
}
