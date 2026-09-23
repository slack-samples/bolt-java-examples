package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows users to select a date from a calendar style UI.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/date-picker-element/}
 */
public class DatePicker {
    /**
     * A section block with a date picker accessory.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section1234")
                .text(BlockCompositions.markdownText("Pick a date for the deadline."))
                .accessory(BlockElements.datePicker(d -> d.actionId("datepicker123")
                        .initialDate("1990-04-28")
                        .placeholder(BlockCompositions.plainText("Select a date")))));
        return block;
    }
}
