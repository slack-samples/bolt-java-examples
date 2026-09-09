package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import java.util.List;

/**
 * Displays rich tables that support pagination, sorting, filtering, and interactivity.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/data-table-block/}
 */
public class DataTable {
    /**
     * A list of fruit and their quantities.
     */
    public static DataTableBlock example01() {
        DataTableBlock block = Blocks.dataTable(t -> t.caption("A list of fruit and their quantities")
                .rows(List.of(
                        List.of(BlockCompositions.rawText("Fruit"), BlockCompositions.rawText("Quantity")),
                        List.of(BlockCompositions.rawText("Apples"), BlockCompositions.rawNumber(12.0, "12")))));
        return block;
    }
}
