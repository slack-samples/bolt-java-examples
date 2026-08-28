package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to choose an option from a drop down menu.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/select-menu-element/}
 */
public class SelectMenu {
    /**
     * A section block with a select menu of static options.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick an item from the dropdown list"))
                .accessory(BlockElements.staticSelect(m -> m.actionId("text1234")
                        .placeholder(plainText("Select an item"))
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
                                        .build())))));
        return block;
    }

    /**
     * A section block with a select menu of options loaded from an external source.
     */
    public static SectionBlock example02() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick an item from the dropdown list"))
                .accessory(BlockElements.externalSelect(m -> m.actionId("text1234")
                        .placeholder(plainText("Select an item"))
                        .minQueryLength(3))));
        return block;
    }

    /**
     * A section block with a select menu of users.
     */
    public static SectionBlock example03() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick a user from the dropdown list"))
                .accessory(BlockElements.usersSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select an item")))));
        return block;
    }

    /**
     * A section block with a select menu of conversations.
     */
    public static SectionBlock example04() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick a conversation from the dropdown list"))
                .accessory(BlockElements.conversationsSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select an item")))));
        return block;
    }

    /**
     * A section block with a select menu of channels.
     */
    public static SectionBlock example05() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick a channel from the dropdown list"))
                .accessory(BlockElements.channelsSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select an item")))));
        return block;
    }
}
