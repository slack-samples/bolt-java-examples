package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.RichTextSectionElement.TextStyle;
import java.util.List;

/**
 * A section element that holds rich text elements.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-section-element/}
 */
public class RichTextSection {
    /**
     * Rich text blocks showing basic, bold, italic, and strikethrough text sections.
     */
    public static List<RichTextBlock> example01() {
        List<RichTextBlock> blocks = List.of(
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(RichTextSectionElement.Text.builder()
                                .text("Hello there, I am a basic rich text block!")
                                .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am a bold rich text block!")
                                        .style(TextStyle.builder().bold(true).build())
                                        .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am an italic rich text block!")
                                        .style(TextStyle.builder().italic(true).build())
                                        .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am a strikethrough rich text block!")
                                        .style(TextStyle.builder().strike(true).build())
                                        .build()))
                        .build()))));
        return blocks;
    }
}
