package chat;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatAppendStreamRequest;
import com.slack.api.methods.response.chat.ChatAppendStreamResponse;
import java.io.IOException;

public class ChatAppendStream {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the chat.appendStream method
        ChatAppendStreamRequest request = ChatAppendStreamRequest.builder()
                .channel("C123ABC456")
                .ts("1234567890.123456")
                .markdownText(" — reading the logs now")
                .build();
        ChatAppendStreamResponse response = methods.chatAppendStream(request);

        // Inspect the response
        System.out.println(response);
    }
}
