package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows user to upload files.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/file-input-element/}
 */
public class FileInput {
    /**
     * An input block with a file input element.
     */
    public static InputBlock example01() {
        InputBlock block = Blocks.input(i -> i.blockId("input_block_id")
                .label(plainText("Upload Files"))
                .element(BlockElements.fileInput(f -> f.actionId("file_input_action_id_1")
                        .filetypes(List.of("jpg", "png"))
                        .maxFiles(5))));
        return block;
    }
}
