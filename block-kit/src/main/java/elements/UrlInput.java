package elements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows user to enter a URL into a single-line field.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/url-input-element/}
 */
public class UrlInput {
    /**
     * An input block with a URL input element.
     */
    public static InputBlock example01() {
        InputBlock block =
                Blocks.input(i -> i.element(BlockElements.urlTextInput(u -> u.actionId("url_text_input-action")))
                        .label(plainText(pt -> pt.text("Label").emoji(true))));
        return block;
    }
}
