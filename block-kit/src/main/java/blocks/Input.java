package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;

/**
 * Collects information from users via elements.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/input-block/}
 */
public class Input {
    /**
     * An input block containing a plain-text input element.
     */
    public static InputBlock example01() {
        InputBlock block = Blocks.input(i -> i.element(BlockElements.plainTextInput(pt -> pt))
                .label(BlockCompositions.plainText(pt -> pt.text("Label").emoji(true))));
        return block;
    }
}
