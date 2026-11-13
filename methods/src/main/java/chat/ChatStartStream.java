package chat;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatStartStreamRequest;
import com.slack.api.methods.response.chat.ChatStartStreamResponse;
import java.io.IOException;

public class ChatStartStream {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the chat.startStream method
        ChatStartStreamRequest request = ChatStartStreamRequest.builder()
                .channel("C123ABC456")
                .threadTs("1234567890.123456")
                .markdownText("Let me look into that")
                .build();
        ChatStartStreamResponse response = methods.chatStartStream(request);

        // Inspect the response
        System.out.println(response);
    }
}
