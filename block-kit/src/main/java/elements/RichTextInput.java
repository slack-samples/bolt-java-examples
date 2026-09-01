package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.DispatchActionConfig;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.view.View;
import com.slack.api.model.view.Views;
import java.util.List;

/**
 * Allows users to enter formatted text in a WYSIWYG composer, offering the same messaging writing experience as in
 * Slack.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-input-element/}
 */
public class RichTextInput {
    /**
     * A home view with an input block containing a rich text input element.
     */
    public static View example01() {
        View view = Views.view(v -> v.type("home").blocks(List.of(Blocks.input(i -> i.element(
                        BlockElements.richTextInput(rt -> rt.actionId("rich_text_input-action")
                                .dispatchActionConfig(DispatchActionConfig.builder()
                                        .triggerActionsOn(List.of("on_character_entered"))
                                        .build())
                                .focusOnLoad(true)
                                .placeholder(BlockCompositions.plainText("Enter text"))))
                .label(BlockCompositions.plainText(l -> l.text("Label").emoji(true)))))));
        return view;
    }
}
