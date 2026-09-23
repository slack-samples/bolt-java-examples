package compositions;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.OptionGroupObject;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Defines a way to group options in a menu.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/option-group-object/}
 */
public class OptionGroup {
    /**
     * A static select menu containing the option group object.
     */
    public static List<LayoutBlock> example01() {
        List<LayoutBlock> blocks = List.of(
                Blocks.section(s -> s.text(BlockCompositions.markdownText(":mag: Search results for *Cata*"))),
                Blocks.divider(),
                Blocks.section(s -> s.text(
                                BlockCompositions.markdownText(
                                        "*<fakeLink.toYourApp.com|Use Case Catalogue>*\nUse Case Catalogue for the following departments/roles..."))
                        .accessory(BlockElements.staticSelect(m -> m.placeholder(BlockCompositions.plainText(
                                        pt -> pt.text("Manage").emoji(true)))
                                .optionGroups(List.of(
                                        OptionGroupObject.builder()
                                                .label(BlockCompositions.plainText("Group 1"))
                                                .options(List.of(
                                                        OptionObject.builder()
                                                                .text(
                                                                        BlockCompositions.plainText(
                                                                                "*this is plain_text text*"))
                                                                .value("value-0")
                                                                .build(),
                                                        OptionObject.builder()
                                                                .text(
                                                                        BlockCompositions.plainText(
                                                                                "*this is plain_text text*"))
                                                                .value("value-1")
                                                                .build(),
                                                        OptionObject.builder()
                                                                .text(
                                                                        BlockCompositions.plainText(
                                                                                "*this is plain_text text*"))
                                                                .value("value-2")
                                                                .build()))
                                                .build(),
                                        OptionGroupObject.builder()
                                                .label(BlockCompositions.plainText("Group 2"))
                                                .options(List.of(OptionObject.builder()
                                                        .text(BlockCompositions.plainText("*this is plain_text text*"))
                                                        .value("value-3")
                                                        .build()))
                                                .build()))))));
        return blocks;
    }
}
