package oauth.v2;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.oauth.OAuthV2BeginShortTokenRotationRequest;
import com.slack.api.methods.response.oauth.OAuthV2BeginShortTokenRotationResponse;
import java.io.IOException;

public class OAuthV2BeginShortTokenRotation {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Initialize
        MethodsClient methods = Slack.getInstance().methods();

        // Call the oauth.v2.beginShortTokenRotation method
        OAuthV2BeginShortTokenRotationRequest request = OAuthV2BeginShortTokenRotationRequest.builder()
                .clientId("4123121235.9872358710")
                .clientSecret("e1b9e11dfcd19c1982d5de12921e17e8c")
                .token("xoxp-12345-67890-1928471-abcdefg")
                .build();
        OAuthV2BeginShortTokenRotationResponse response = methods.oauthV2BeginShortTokenRotation(request);

        // Inspect the response
        System.out.println(response);
    }
}
