package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows users to enter numerical data into a single-line field.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/time-picker-element/}
 */
public class TimePicker {
    /**
     * A section block with a time picker accessory.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section1234")
                .text(BlockCompositions.markdownText("Pick a date for the deadline."))
                .accessory(BlockElements.timePicker(t -> t.timezone("America/Los_Angeles")
                        .actionId("timepicker123")
                        .initialTime("11:40")
                        .placeholder(BlockCompositions.plainText("Select a time")))));
        return block;
    }
}
