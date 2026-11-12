package slackbot.skills.library;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.slackbot.skills.library.SlackbotSkillsLibraryRemoveRequest;
import com.slack.api.methods.response.slackbot.skills.library.SlackbotSkillsLibraryRemoveResponse;
import java.io.IOException;

public class SlackbotSkillsLibraryRemove {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the slackbot.skills.library.remove method
        SlackbotSkillsLibraryRemoveRequest request = SlackbotSkillsLibraryRemoveRequest.builder()
                .skillId("F0123ABCD")
                .build();
        SlackbotSkillsLibraryRemoveResponse response = methods.slackbotSkillsLibraryRemove(request);

        // Inspect the response
        System.out.println(response);
    }
}
