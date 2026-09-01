package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextPreformattedElement;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a preformatted rich text element.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/rich-text-preformatted-element/}
 */
public class RichTextPreformatted {
    /**
     * A rich text block with a preformatted code section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextPreformattedElement.builder()
                .border(0)
                .elements(List.of(RichTextSectionElement.Text.builder()
                        .text(
                                "{\n  \"object\": {\n    \"description\": \"this is an example of a json object\"\n  }\n}")
                        .build()))
                .build())));
        return block;
    }
}
