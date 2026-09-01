package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a color swatch from a hex value.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/color-element/}
 */
public class Color {
    /**
     * A rich text block with a color element in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(
                        RichTextSectionElement.Color.builder().value("#F405B3").build()))
                .build())));
        return block;
    }
}
