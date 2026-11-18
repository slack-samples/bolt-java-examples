package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Renders as a mention of a user group.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/usergroup-element/}
 */
public class UserGroup {
    /**
     * A rich text block with a user group mention in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.UserGroup.builder()
                        .usergroupId("G123ABC456")
                        .build()))
                .build())));
        return block;
    }
}
