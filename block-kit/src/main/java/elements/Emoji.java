package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays an emoji.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/emoji-element/}
 */
public class Emoji {
    /**
     * A rich text block with emoji elements in a section.
     */
    public static RichTextBlock example01() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(
                        RichTextSectionElement.Emoji.builder()
                                .name("basketball")
                                .build(),
                        RichTextSectionElement.Text.builder().text(" ").build(),
                        RichTextSectionElement.Emoji.builder()
                                .name("snowboarder")
                                .build(),
                        RichTextSectionElement.Text.builder().text(" ").build(),
                        RichTextSectionElement.Emoji.builder()
                                .name("checkered_flag")
                                .build()))
                .build())));
        return block;
    }
}
