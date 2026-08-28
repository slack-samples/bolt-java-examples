package compositionobjects;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.ActionsBlock;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.ConfirmationDialogObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Defines a dialog that adds a confirmation step to interactive elements.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/confirmation-dialog-object/}
 */
public class ConfirmationDialog {
    /**
     * An actions block with a button carrying a confirmation dialog.
     */
    public static ActionsBlock example01() {
        ActionsBlock block = Blocks.actions(a -> a.elements(List.of(
                BlockElements.button(
                        b -> b.text(plainText(pt -> pt.text("Approve").emoji(true)))
                                .confirm(ConfirmationDialogObject.builder()
                                        .title(plainText("Are you sure?"))
                                        .text(markdownText("Would you not prefer a good game of _chess_?"))
                                        .confirm(plainText("Do it"))
                                        .deny(plainText("Stop, I changed my mind!"))
                                        .build())
                                .style("primary")
                                .value("click_me_123")),
                BlockElements.button(b -> b.text(plainText(pt -> pt.text("Deny").emoji(true)))
                        .style("danger")
                        .value("click_me_123")))));
        return block;
    }
}
