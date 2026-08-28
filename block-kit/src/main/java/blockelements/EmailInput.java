package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows user to enter an email into a single-line field.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/email-input-element/}
 */
public class EmailInput {
    /**
     * An input block with an email input element.
     */
    public static InputBlock example01() {
        InputBlock block = Blocks.input(i -> i.blockId("input123")
                .label(plainText("Email Address"))
                .element(BlockElements.emailTextInput(
                        e -> e.actionId("email_text_input-action").placeholder(plainText("Enter an email")))));
        return block;
    }
}
