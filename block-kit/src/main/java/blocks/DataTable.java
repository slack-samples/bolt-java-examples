package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.model.block.composition.RawNumberObject;
import com.slack.api.model.block.composition.RawTextObject;
import java.util.List;

/**
 * Displays rich tables that support pagination, sorting, filtering, and interactivity.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/data-table-block/}
 */
public class DataTable {
    /**
     * A data table pairing text labels with numeric values.
     */
    public static DataTableBlock example01() {
        DataTableBlock block = Blocks.dataTable(t -> t.caption("Quarterly widget report")
                .pageSize(10)
                .rowHeaderColumnIndex(0)
                .rows(List.of(
                        List.of(
                                RawTextObject.builder().text("Item").build(),
                                RawTextObject.builder().text("Count").build()),
                        List.of(
                                RawTextObject.builder().text("Widgets").build(),
                                RawNumberObject.builder().value(42.0).text("42").build()),
                        List.of(
                                RawTextObject.builder().text("Gadgets").build(),
                                RawNumberObject.builder().value(7.0).text("7").build()))));
        return block;
    }
}
