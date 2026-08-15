package blocks;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.blocks.BlocksValidateRequest;
import com.slack.api.methods.response.blocks.BlocksValidateResponse;
import java.io.IOException;

public class BlocksValidate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Initialize
        MethodsClient methods = Slack.getInstance().methods();

        // Call blocks.validate with a well-formed payload
        String validBlocks = "[{\"type\":\"section\",\"text\":{\"type\":\"mrkdwn\",\"text\":\"Hello\"}}]";
        BlocksValidateResponse valid = methods.blocksValidate(
                BlocksValidateRequest.builder().blocks(validBlocks).build());

        // Inspect the response
        System.out.println(valid);

        // Call blocks.validate with a malformed payload
        String invalidBlocks = "[{\"type\":\"section\"}]";
        BlocksValidateResponse invalid = methods.blocksValidate(
                BlocksValidateRequest.builder().blocks(invalidBlocks).build());

        // Inspect the response
        System.out.println(invalid);
    }
}
