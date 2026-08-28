package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * A time picker element; on desktop a dropdown with free-text entry, on mobile the native time picker UI.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/time-picker-element/}
 */
public class TimePicker {
    /**
     * A section block with a time picker accessory.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section1234")
                .text(markdownText("Pick a date for the deadline."))
                .accessory(BlockElements.timePicker(t -> t.timezone("America/Los_Angeles")
                        .actionId("timepicker123")
                        .initialTime("11:40")
                        .placeholder(plainText("Select a time")))));
        return block;
    }
}
