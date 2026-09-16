package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextQuoteElement;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a rich text quote block.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-quote-element/}
 */
public class RichTextQuote {
    /**
     * A rich text block with a quote followed by a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("Vrzsu")
                .elements(List.of(
                        RichTextQuoteElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("What we need is good examples in our documentation.")
                                        .build()))
                                .build(),
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("Yes - I completely agree, Luke!")
                                        .build()))
                                .build())));
        return block;
    }
}
