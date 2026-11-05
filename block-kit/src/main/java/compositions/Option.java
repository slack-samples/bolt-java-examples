package compositions;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Defines a single item in a number of item selection elements.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/option-object/}
 */
public class Option {
    /**
     * A single option object.
     */
    public static OptionObject example01() {
        OptionObject option = OptionObject.builder()
                .text(BlockCompositions.plainText(pt -> pt.text("Save it").emoji(true)))
                .value("value-2")
                .build();
        return option;
    }

    /**
     * A static select menu element with several option objects.
     */
    public static List<LayoutBlock> example02() {
        List<LayoutBlock> blocks = List.of(
                Blocks.section(s -> s.text(BlockCompositions.markdownText(":mag: Search results for *Cata*"))),
                Blocks.divider(),
                Blocks.section(s -> s.text(
                                BlockCompositions.markdownText(
                                        "*<fakeLink.toYourApp.com|Use Case Catalogue>*\nUse Case Catalogue for the following departments/roles..."))
                        .accessory(BlockElements.staticSelect(m -> m.placeholder(BlockCompositions.plainText(
                                        pt -> pt.text("Manage").emoji(true)))
                                .options(List.of(
                                        OptionObject.builder()
                                                .text(BlockCompositions.plainText(
                                                        pt -> pt.text("Edit it").emoji(true)))
                                                .value("value-0")
                                                .build(),
                                        OptionObject.builder()
                                                .text(BlockCompositions.plainText(
                                                        pt -> pt.text("Read it").emoji(true)))
                                                .value("value-1")
                                                .build(),
                                        OptionObject.builder()
                                                .text(BlockCompositions.plainText(
                                                        pt -> pt.text("Save it").emoji(true)))
                                                .value("value-2")
                                                .build()))))));
        return blocks;
    }
}
