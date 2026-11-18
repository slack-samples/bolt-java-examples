package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to press a button to view a list of options.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/overflow-menu-element/}
 */
public class OverflowMenu {
    /**
     * A section block with an overflow menu accessory.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section 890")
                .text(BlockCompositions.markdownText("This is a section block with an overflow menu."))
                .accessory(BlockElements.overflowMenu(o -> o.actionId("overflow")
                        .options(List.of(
                                OptionObject.builder()
                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                        .value("value-0")
                                        .build(),
                                OptionObject.builder()
                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                        .value("value-1")
                                        .build(),
                                OptionObject.builder()
                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                        .value("value-2")
                                        .build(),
                                OptionObject.builder()
                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                        .value("value-3")
                                        .build(),
                                OptionObject.builder()
                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                        .value("value-4")
                                        .build())))));
        return block;
    }
}
