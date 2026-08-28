package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * An icon button to perform actions.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/icon-button-element/}
 */
public class IconButton {
    /**
     * A context actions block with an icon button element.
     */
    public static ContextActionsBlock example01() {
        ContextActionsBlock block = Blocks.contextActions(List.of(BlockElements.iconButton(ib -> ib.icon("trash")
                .text(plainText("Delete"))
                .actionId("delete_button")
                .value("delete_item"))));
        return block;
    }
}
