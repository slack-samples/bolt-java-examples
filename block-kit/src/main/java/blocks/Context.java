package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ContextBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Provides contextual info, which can include both images and text.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/context-block/}
 */
public class Context {
    /**
     * A context block with an image and text.
     */
    public static ContextBlock example01() {
        ContextBlock block = Blocks.context(c -> c.elements(List.of(
                BlockElements.image(i -> i.imageUrl("https://image.freepik.com/free-photo/red-drawing-pin_1156-445.jpg")
                        .altText("images")),
                BlockCompositions.markdownText("Location: **Dogpatch**"))));
        return block;
    }
}
