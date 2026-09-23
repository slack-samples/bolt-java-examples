package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a formatted, localized date.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/date-element/}
 */
public class Date {
    /**
     * A rich text block with a date element in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Date.builder()
                        .timestamp(1720710212)
                        .format("{date_num} at {time}")
                        .fallback("timey")
                        .build()))
                .build())));
        return block;
    }
}
