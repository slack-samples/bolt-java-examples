package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Displays text, possibly alongside elements.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/section-block/}
 */
public class Section {
    /**
     * A text section block.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s ->
                s.text(BlockCompositions.markdownText("A message *with some bold text* and _some italicized text_.")));
        return block;
    }

    /**
     * A section block containing text fields.
     */
    public static SectionBlock example02() {
        SectionBlock block = Blocks.section(s -> s.text(
                        BlockCompositions.markdownText("A message *with some bold text* and _some italicized text_."))
                .fields(List.of(
                        BlockCompositions.markdownText("High"),
                        BlockCompositions.plainText(pt -> pt.text("Silly").emoji(true)))));
        return block;
    }

    /**
     * A section block containing a datepicker element.
     */
    public static SectionBlock example03() {
        SectionBlock block = Blocks.section(s -> s.text(
                        BlockCompositions.markdownText("*Haley* has requested you set a deadline for finding a house"))
                .accessory(BlockElements.datePicker(d -> d.actionId("datepicker123")
                        .initialDate("1990-04-28")
                        .placeholder(BlockCompositions.plainText("Select a date")))));
        return block;
    }
}
