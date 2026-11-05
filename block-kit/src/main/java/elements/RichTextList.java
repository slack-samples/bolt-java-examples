package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextListElement;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a list of rich text items.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-list-element/}
 */
public class RichTextList {
    /**
     * A rich text block with a bulleted list.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("block1")
                .elements(List.of(
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("My favorite Slack features (in no particular order):")
                                        .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .indent(0)
                                .border(1)
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Huddles")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Canvas")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Developing with Block Kit")
                                                        .build()))
                                                .build()))
                                .build())));
        return block;
    }

    /**
     * A rich text block with nested bulleted lists using indent.
     */
    public static RichTextBlock example02() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("block1")
                .elements(List.of(
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("Breakfast foods I enjoy:")
                                        .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Hashbrowns")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Eggs")
                                                        .build()))
                                                .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .indent(1)
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Scrambled")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Over easy")
                                                        .build()))
                                                .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Text.builder()
                                                .text("Pancakes, extra syrup")
                                                .build()))
                                        .build()))
                                .build())));
        return block;
    }
}
