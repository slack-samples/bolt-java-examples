package slackbot.skills.library;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.library.SlackbotSkillsLibraryAddRequest;
import com.slack.api.methods.response.slackbot.skills.library.SlackbotSkillsLibraryAddResponse;
import java.io.IOException;

public class SlackbotSkillsLibraryAdd {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.library.add method
        SlackbotSkillsLibraryAddRequest request =
                SlackbotSkillsLibraryAddRequest.builder().skillId("F0123ABCD").build();
        SlackbotSkillsLibraryAddResponse response = methods.slackbotSkillsLibraryAdd(request);

        // Inspect the response
        System.out.println(response);
    }
}
