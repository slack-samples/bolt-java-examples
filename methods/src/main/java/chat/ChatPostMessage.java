package chat;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import java.io.IOException;

/**
 * Sends a message to a channel with the chat.postMessage method.
 * {@link https://docs.slack.dev/reference/methods/chat.postmessage}
 */
public class ChatPostMessage {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the chat.postMessage method
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("C123ABC456")
                .text("Here's a message for you")
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        // Inspect the response
        System.out.println(response);
    }
}
