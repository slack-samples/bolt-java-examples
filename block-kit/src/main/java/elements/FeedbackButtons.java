package elements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.model.block.composition.FeedbackButtonObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Buttons to indicate positive or negative feedback.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/feedback-buttons-element/}
 */
public class FeedbackButtons {
    /**
     * A context actions block with a feedback buttons element.
     */
    public static ContextActionsBlock example01() {
        ContextActionsBlock block =
                Blocks.contextActions(List.of(BlockElements.feedbackButtons(fb -> fb.actionId("feedback_buttons_1")
                        .positiveButton(FeedbackButtonObject.builder()
                                .text(plainText("Good"))
                                .value("positive_feedback")
                                .accessibilityLabel("Mark this response as good")
                                .build())
                        .negativeButton(FeedbackButtonObject.builder()
                                .text(plainText("Bad"))
                                .value("negative_feedback")
                                .accessibilityLabel("Mark this response as bad")
                                .build()))));
        return block;
    }
}
