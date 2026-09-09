package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.model.block.composition.RawTextObject;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.RichTextSectionElement.TextStyle;
import java.util.List;

/**
 * Displays rich tables that support pagination, sorting, filtering, and interactivity.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/data-table-block/}
 */
public class DataTable {
    /**
     * A data table of departments with rich text badge cells.
     */
    public static DataTableBlock example01() {
        DataTableBlock block = Blocks.dataTable(t -> t.caption("A Fabulous Table")
                .rows(List.of(
                        List.of(
                                RawTextObject.builder().text("Name").build(),
                                RawTextObject.builder().text("Department").build(),
                                RawTextObject.builder().text("Badge").build()),
                        List.of(
                                RawTextObject.builder()
                                        .text("Data Refinement Department")
                                        .build(),
                                RawTextObject.builder().text("MDR").build(),
                                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Text.builder()
                                                .text("Blue")
                                                .style(TextStyle.builder()
                                                        .bold(true)
                                                        .build())
                                                .build()))
                                        .build())))),
                        List.of(
                                RawTextObject.builder()
                                        .text("Art Sourcing Department")
                                        .build(),
                                RawTextObject.builder().text("O&D").build(),
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
                                RawTextObject.builder()
                                        .text("Wellness Department")
                                        .build(),
                                RawTextObject.builder().text("Wellness Center").build(),
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
