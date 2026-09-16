package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Renders as a mention of a user.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/user-element/}
 */
public class User {
    /**
     * A rich text block with a user mention in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.User.builder()
                        .userId("U123ABC456")
                        .build()))
                .build())));
        return block;
    }
}
