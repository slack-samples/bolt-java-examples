package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a broadcast mention such as here, channel, or everyone.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/broadcast-element/}
 */
public class Broadcast {
    /**
     * A rich text block with a broadcast mention in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Broadcast.builder()
                        .range("everyone")
                        .build()))
                .build())));
        return block;
    }
}
