package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.DividerBlock;

/**
 * Visually separates pieces of info inside of a message.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/divider-block/}
 */
public class Divider {
    /**
     * A simple divider block.
     */
    public static DividerBlock example01() {
        DividerBlock block = Blocks.divider();
        return block;
    }
}
