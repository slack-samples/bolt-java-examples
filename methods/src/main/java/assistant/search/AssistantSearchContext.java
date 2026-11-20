package assistant.search;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.assistant.search.AssistantSearchContextRequest;
import com.slack.api.methods.response.asssistant.search.AssistantSearchContextResponse;
import java.io.IOException;
import java.util.Arrays;

public class AssistantSearchContext {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the assistant.search.context method
        AssistantSearchContextRequest request = AssistantSearchContextRequest.builder()
                .query("What is the latest on project Gizmo?")
                .termClauses(Arrays.asList("project gizmo"))
                .actionToken("12345.98765.abcd2358fdea")
                .channelTypes(Arrays.asList("public_channel", "private_channel", "mpim", "im"))
                .contentTypes(Arrays.asList("messages", "files", "channels"))
                .includeContextMessages(true)
                .includeBots(false)
                .sort("timestamp")
                .sortDir("asc")
                .before(1755191113)
                .after(1752512713)
                .includeMessageBlocks(true)
                .build();
        AssistantSearchContextResponse response = methods.assistantSearchContext(request);

        // Inspect the response
        System.out.println(response);
    }
}
