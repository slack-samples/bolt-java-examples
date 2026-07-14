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

    public static ChatPostMessageResponse example01(Slack slack) throws IOException, SlackApiException {
        // Read a token from the environment variables
        String token = System.getenv("SLACK_TOKEN");

        // Initialize an API Methods client with the given token
        MethodsClient methods = slack.methods(token);

        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("C123ABC456")
                .text("Here's a message for you")
                .build();

        // Get a response as a Java object
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        return response;
    }

    public static void main(String[] args) throws IOException, SlackApiException {
        System.out.println(example01(Slack.getInstance()));
    }
}
