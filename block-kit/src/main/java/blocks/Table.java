package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.TableBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays structured information in a table.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/table-block/}
 */
public class Table {
    /**
     * A table with the first column wrapped and the second column right aligned.
     */
    public static TableBlock example01() {
        TableBlock block = Blocks.table(t -> t.columnSettings(List.of(
                        TableBlock.ColumnSetting.builder().isWrapped(true).build(),
                        TableBlock.ColumnSetting.builder().align("right").build()))
                .rows(List.of(
                        List.of(BlockCompositions.rawText("Header A"), BlockCompositions.rawText("Header B")),
                        List.of(
                                BlockCompositions.rawText("Data 1A"),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Link.builder()
                                                .text("Data 1B")
                                                .url("https://slack.com")
                                                .build()))
                                        .build())))),
                        List.of(
                                BlockCompositions.rawText("Data 2A"),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Link.builder()
                                                .text("Data 2B")
                                                .url("https://slack.com")
                                                .build()))
                                        .build())))))));
        return block;
    }
}
