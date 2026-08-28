package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows users to enter freeform text data into a single-line or multi-line field.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/plain-text-input-element/}
 */
public class PlainTextInput {
    /**
     * An input block with a plain-text input element.
     */
    public static InputBlock example01() {
        InputBlock block =
                Blocks.input(i -> i.element(BlockElements.plainTextInput(pt -> pt.actionId("plain_text_input-action")))
                        .label(plainText(l -> l.text("Label").emoji(true))));
        return block;
    }
}
