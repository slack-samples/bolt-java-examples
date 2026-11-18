package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Renders as a link to a canvas.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/canvas-element/}
 */
public class Canvas {
    /**
     * A rich text block with a canvas link in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Canvas.builder()
                        .fileId("F123ABC456")
                        .build()))
                .build())));
        return block;
    }
}
