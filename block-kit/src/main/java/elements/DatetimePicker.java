package elements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.element.BlockElements;

/**
 * Allows users to select both a date and a time of day.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/datetime-picker-element/}
 */
public class DatetimePicker {
    /**
     * An input block with a datetime picker element.
     */
    public static InputBlock example01() {
        InputBlock block =
                Blocks.input(i -> i.element(BlockElements.datetimePicker(d -> d.actionId("datetimepicker-action")))
                        .hint(plainText(pt -> pt.text("This is some hint text").emoji(true)))
                        .label(plainText(pt -> pt.text("Start date").emoji(true))));
        return block;
    }
}
