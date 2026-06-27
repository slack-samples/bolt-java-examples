package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.FeedbackButtonObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Displays interactive elements at the message level.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/context-actions-block/}
 */
public class ContextActions {
    /**
     * A context actions block with feedback buttons.
     */
    public static ContextActionsBlock example01() {
        ContextActionsBlock block = Blocks.contextActions(
                c -> c.elements(List.of(BlockElements.feedbackButtons(f -> f.actionId("feedback_buttons_1")
                        .positiveButton(FeedbackButtonObject.builder()
                                .text(BlockCompositions.plainText("👍"))
                                .value("positive_feedback")
                                .build())
                        .negativeButton(FeedbackButtonObject.builder()
                                .text(BlockCompositions.plainText("👎"))
                                .value("negative_feedback")
                                .build())))));
        return block;
    }

    /**
     * A context actions block with an icon button.
     */
    public static ContextActionsBlock example02() {
        ContextActionsBlock block =
                Blocks.contextActions(c -> c.elements(List.of(BlockElements.iconButton(i -> i.icon("trash")
                        .text(BlockCompositions.plainText("Delete"))
                        .actionId("delete_button_1")
                        .value("delete_item")))));
        return block;
    }
}
