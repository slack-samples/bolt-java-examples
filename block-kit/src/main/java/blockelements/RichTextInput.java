package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.composition.DispatchActionConfig;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to enter formatted text in a WYSIWYG composer, offering the same messaging writing experience as in
 * Slack.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-input-element/}
 */
public class RichTextInput {
    /**
     * An input block with a rich text input element.
     */
    public static InputBlock example01() {
        InputBlock block =
                Blocks.input(i -> i.element(BlockElements.richTextInput(rt -> rt.actionId("rich_text_input-action")
                                .dispatchActionConfig(DispatchActionConfig.builder()
                                        .triggerActionsOn(List.of("on_character_entered"))
                                        .build())
                                .focusOnLoad(true)
                                .placeholder(plainText("Enter text"))))
                        .label(plainText(l -> l.text("Label").emoji(true))));
        return block;
    }
}
