package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.HeaderBlock;
import com.slack.api.model.block.composition.BlockCompositions;

/**
 * Displays a larger-sized text.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/header-block/}
 */
public class Header {
    /**
     * A simple header block.
     */
    public static HeaderBlock example01() {
        HeaderBlock block = Blocks.header(h -> h.text(BlockCompositions.plainText("A Heartfelt Header")));
        return block;
    }
}
