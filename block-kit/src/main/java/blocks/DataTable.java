package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.RichTextSectionElement.TextStyle;
import java.util.List;

/**
 * Displays rich tables that support pagination, sorting, filtering, and interactivity.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/data-table-block/}
 */
public class DataTable {
    /**
     * A sample data table block.
     */
    public static DataTableBlock example01() {
        DataTableBlock block = Blocks.dataTable(t -> t.caption("A Fabulous Table")
                .rows(List.of(
                        List.of(
                                BlockCompositions.rawText("Name"),
                                BlockCompositions.rawText("Department"),
                                BlockCompositions.rawText("Badge")),
                        List.of(
                                BlockCompositions.rawText("Data Refinement Department"),
                                BlockCompositions.rawText("MDR"),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Text.builder()
                                                .text("Blue")
                                                .style(TextStyle.builder()
                                                        .bold(true)
                                                        .build())
                                                .build()))
                                        .build())))),
                        List.of(
                                BlockCompositions.rawText("Art Sourcing Department"),
                                BlockCompositions.rawText("O&D"),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(
                                                RichTextSectionElement.Text.builder()
                                                        .text("Green")
                                                        .build(),
                                                RichTextSectionElement.Text.builder()
                                                        .text("review")
                                                        .style(
                                                                TextStyle.builder()
                                                                        .italic(true)
                                                                        .build())
                                                        .build()))
                                        .build())))),
                        List.of(
                                BlockCompositions.rawText("Wellness Department"),
                                BlockCompositions.rawText("Wellness Center"),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Text.builder()
                                                .text("Limited")
                                                .style(TextStyle.builder()
                                                        .bold(true)
                                                        .build())
                                                .build()))
                                        .build())))))));
        return block;
    }
}
