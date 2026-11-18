package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a hyperlink.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/link-element/}
 */
public class Link {
    /**
     * A rich text block with a link element in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Link.builder()
                        .url("https://docs.slack.dev")
                        .build()))
                .build())));
        return block;
    }
}
