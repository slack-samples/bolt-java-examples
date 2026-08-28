package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows user to enter a number into a single-line field.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/number-input-element/}
 */
public class NumberInput {
    /**
     * An input block with a number input element.
     */
    public static InputBlock example01() {
        InputBlock block = Blocks.input(i -> i.element(
                        BlockElements.numberInput(n -> n.decimalAllowed(false).actionId("number_input-action")))
                .label(plainText(pt -> pt.text("Label").emoji(true))));
        return block;
    }
}
