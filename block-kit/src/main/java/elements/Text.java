package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.RichTextSectionElement.TextStyle;
import java.util.List;

/**
 * Displays text, optionally with styling.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/text-element/}
 */
public class Text {
    /**
     * A rich text block with plain and bold text elements in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(
                        RichTextSectionElement.Text.builder()
                                .text("Hello there, ")
                                .build(),
                        RichTextSectionElement.Text.builder()
                                .text("I am a bold rich text block!")
                                .style(TextStyle.builder().bold(true).build())
                                .build()))
                .build())));
        return block;
    }
}
