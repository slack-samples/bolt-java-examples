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

        // Call the blocks.validate method
        String blocks = "[{\"type\": \"section\", \"text\": {\"type\": \"plain_text\", \"text\": \"Hello world\"}}]";
        BlocksValidateRequest request =
                BlocksValidateRequest.builder().blocks(blocks).build();
        BlocksValidateResponse response = methods.blocksValidate(request);

        // Inspect the response
        System.out.println(response);
    }
}
