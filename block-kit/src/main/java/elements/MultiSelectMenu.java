package elements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to select multiple items from a list of options.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/multi-select-menu-element/}
 */
public class MultiSelectMenu {
    /**
     * A section block with a multi-select menu of static options.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick items from the list"))
                .accessory(BlockElements.multiStaticSelect(m -> m.actionId("text1234")
                        .placeholder(plainText("Select items"))
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
     * A section block with a multi-select menu of options loaded from an external source.
     */
    public static SectionBlock example02() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick items from the list"))
                .accessory(BlockElements.multiExternalSelect(m -> m.actionId("text1234")
                        .placeholder(plainText("Select items"))
                        .minQueryLength(3))));
        return block;
    }

    /**
     * A section block with a multi-select menu of users.
     */
    public static SectionBlock example03() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick users from the list"))
                .accessory(BlockElements.multiUsersSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select users")))));
        return block;
    }

    /**
     * A section block with a multi-select menu of conversations.
     */
    public static SectionBlock example04() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick conversations from the list"))
                .accessory(BlockElements.multiConversationsSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select conversations")))));
        return block;
    }

    /**
     * A section block with a multi-select menu of channels.
     */
    public static SectionBlock example05() {
        SectionBlock block = Blocks.section(s -> s.blockId("section678")
                .text(markdownText("Pick channels from the list"))
                .accessory(BlockElements.multiChannelsSelect(
                        m -> m.actionId("text1234").placeholder(plainText("Select channels")))));
        return block;
    }
}
