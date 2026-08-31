package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ContainerBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * A general-purpose wrapper for grouping child blocks together, with a configurable size.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/container-block/}
 */
public class Container {
    /**
     * A collapsible container with sections, a divider, context, and actions.
     */
    public static ContainerBlock example01() {
        ContainerBlock block = Blocks.container(c -> c.blockId("bkb_container_bulk_update")
                .title(BlockCompositions.plainText("Bulk update: 2 records selected"))
                .subtitle(BlockCompositions.plainText("Review changes before confirming"))
                .isCollapsible(true)
                .childBlocks(Blocks.asBlocks(
                        Blocks.section(s -> s.blockId("record-row-1")
                                .text(BlockCompositions.markdownText(
                                        "*DCW-1024*\nStatus: Open → Closed\nAssignee: @princessdonut → @carl"))),
                        Blocks.divider(d -> d.blockId("bulk-div-1")),
                        Blocks.section(s -> s.blockId("record-row-2")
                                .text(BlockCompositions.markdownText(
                                        "*DCW-1025*\nStatus: In Progress → Closed\nAssignee: @mordecai → @carl"))),
                        Blocks.divider(d -> d.blockId("bulk-div-2")),
                        Blocks.context(ctx -> ctx.blockId("bulk-status-bar")
                                .elements(List.of(BlockCompositions.markdownText(
                                        ":white_check_mark: 2 records will be updated • Status → Closed • Assignee → @carl")))),
                        Blocks.actions(a -> a.blockId("bulk-actions")
                                .elements(List.of(
                                        BlockElements.button(b -> b.text(
                                                        BlockCompositions.plainText(pt -> pt.text("Confirm All").emoji(true)))
                                                .style("primary")
                                                .actionId("bulk_confirm")),
                                        BlockElements.button(b -> b.text(
                                                        BlockCompositions.plainText(pt -> pt.text("Cancel").emoji(true)))
                                                .actionId("bulk_cancel"))))))));
        return block;
    }
}
