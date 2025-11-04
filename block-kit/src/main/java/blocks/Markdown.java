package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.MarkdownBlock;

/**
 * Displays formatted markdown.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/markdown-block/}
 */
public class Markdown {
    /**
     * A markdown block.
     */
    public static MarkdownBlock example01() {
        MarkdownBlock block = Blocks.markdown(m -> m.text("**Lots of information here!!**"));
        return block;
    }
}
