package oauth.v2.user;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.oauth.OAuthV2UserAccessRequest;
import com.slack.api.methods.response.oauth.OAuthV2UserAccessResponse;
import java.io.IOException;

public class OAuthV2UserAccess {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Initialize
        MethodsClient methods = Slack.getInstance().methods();

        // Call the oauth.v2.user.access method
        OAuthV2UserAccessRequest request = OAuthV2UserAccessRequest.builder()
                .clientId("2141029472.691202649728")
                .clientSecret("e1b9e11dfcd19c1982d5de12921e17e8c")
                .code("4724469134.4644010092847.232b4e6d82c333b475fc30f5f5a341d294feb1a94392c2fd791f7ab7731a443d1a")
                .build();
        OAuthV2UserAccessResponse response = methods.oauthV2UserAccess(request);

        // Inspect the response
        System.out.println(response);
    }
}
