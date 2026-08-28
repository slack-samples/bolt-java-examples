package compositionobjects;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.composition.DispatchActionConfig;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Defines when a plain-text input element will return a block_actions interaction payload.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/dispatch-action-configuration-object/}
 */
public class DispatchActionConfiguration {
    /**
     * An input block with a multiline plain-text input carrying a dispatch action configuration.
     */
    public static InputBlock example01() {
        InputBlock block = Blocks.input(i -> i.dispatchAction(true)
                .element(BlockElements.plainTextInput(pt -> pt.multiline(true)
                        .dispatchActionConfig(DispatchActionConfig.builder()
                                .triggerActionsOn(List.of("on_character_entered"))
                                .build())))
                .label(plainText(
                        l -> l.text("This is a multiline plain-text input").emoji(true))));
        return block;
    }
}
