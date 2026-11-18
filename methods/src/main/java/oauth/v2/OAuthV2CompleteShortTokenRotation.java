package oauth.v2;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.oauth.OAuthV2CompleteShortTokenRotationRequest;
import com.slack.api.methods.response.oauth.OAuthV2CompleteShortTokenRotationResponse;
import java.io.IOException;

public class OAuthV2CompleteShortTokenRotation {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Initialize
        MethodsClient methods = Slack.getInstance().methods();

        // Call the oauth.v2.completeShortTokenRotation method
        OAuthV2CompleteShortTokenRotationRequest request = OAuthV2CompleteShortTokenRotationRequest.builder()
                .clientId("4123121235.9872358710")
                .clientSecret("e1b9e11dfcd19c1982d5de12921e17e8c")
                .token("xoxp-12345-67890-1928471-abcdefg")
                .newToken("xoxp-12345-67890-1928471-qemwiiwglagjacakvqbvbfkmvbsvsuzn")
                .build();
        OAuthV2CompleteShortTokenRotationResponse response = methods.oauthV2CompleteShortTokenRotation(request);

        // Inspect the response
        System.out.println(response);
    }
}
