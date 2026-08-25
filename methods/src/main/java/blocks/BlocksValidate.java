package blocks;

import static com.slack.api.model.block.Blocks.section;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.blocks.BlocksValidateRequest;
import com.slack.api.methods.response.blocks.BlocksValidateResponse;
import java.io.IOException;
import java.util.Arrays;

public class BlocksValidate {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Initialize (blocks.validate is unauthenticated, so no token is needed)
        MethodsClient methods = Slack.getInstance().methods();

        // Build blocks with the SDK's Block Kit builders and validate them
        BlocksValidateRequest request = BlocksValidateRequest.builder()
                .blocks(Arrays.asList(section(s -> s.text(plainText("Hello world")))))
                .build();
        BlocksValidateResponse response = methods.blocksValidate(request);

        // Inspect the response
        System.out.println(response);
    }
}
