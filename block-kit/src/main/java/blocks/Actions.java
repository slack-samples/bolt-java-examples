package blocks;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.ActionsBlock;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Holds multiple interactive elements.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/actions-block/}
 */
public class Actions {
    /**
     * An actions block with a select menu and a button.
     */
    public static ActionsBlock example01() {
        ActionsBlock block = Blocks.actions(a -> a.blockId("actions1")
                .elements(List.of(
                        BlockElements.staticSelect(s -> s.actionId("select_2")
                                .placeholder(BlockCompositions.plainText("Which witch is the witchiest witch?"))
                                .options(List.of(
                                        OptionObject.builder()
                                                .text(plainText("Matilda"))
                                                .value("matilda")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("Glinda"))
                                                .value("glinda")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("Granny Weatherwax"))
                                                .value("grannyWeatherwax")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("Hermione"))
                                                .value("hermione")
                                                .build()))),
                        BlockElements.button(b -> b.text(BlockCompositions.plainText("Cancel"))
                                .value("cancel")
                                .actionId("button_1")))));
        return block;
    }

    /**
     * An actions block with a datepicker, an overflow, and a button.
     */
    public static ActionsBlock example02() {
        ActionsBlock block = Blocks.actions(a -> a.blockId("actionblock789")
                .elements(List.of(
                        BlockElements.datePicker(d -> d.actionId("datepicker123")
                                .initialDate("1990-04-28")
                                .placeholder(BlockCompositions.plainText("Select a date"))),
                        BlockElements.overflowMenu(o -> o.actionId("overflow")
                                .options(List.of(
                                        OptionObject.builder()
                                                .text(plainText("*this is plain_text text*"))
                                                .value("value-0")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("*this is plain_text text*"))
                                                .value("value-1")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("*this is plain_text text*"))
                                                .value("value-2")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("*this is plain_text text*"))
                                                .value("value-3")
                                                .build(),
                                        OptionObject.builder()
                                                .text(plainText("*this is plain_text text*"))
                                                .value("value-4")
                                                .build()))),
                        BlockElements.button(b -> b.text(BlockCompositions.plainText("Click Me"))
                                .value("click_me_123")
                                .actionId("button")))));
        return block;
    }
}
