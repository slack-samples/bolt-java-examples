package chat;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatStopStreamRequest;
import com.slack.api.methods.response.chat.ChatStopStreamResponse;
import java.io.IOException;

public class ChatStopStream {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the chat.stopStream method
        ChatStopStreamRequest request = ChatStopStreamRequest.builder()
                .channel("C123ABC456")
                .ts("1234567890.123456")
                .build();
        ChatStopStreamResponse response = methods.chatStopStream(request);

        // Inspect the response
        System.out.println(response);
    }
}
