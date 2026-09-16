package blocks;

import com.slack.api.model.block.AlertBlock;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;

/**
 * Displays alerts, warnings, and informational messages.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/alert-block/}
 */
public class Alert {
    /**
     * An informational alert block.
     */
    public static AlertBlock example01() {
        AlertBlock block = Blocks.alert(a -> a.text(BlockCompositions.markdownText(
                        mt -> mt.text("The work is mysterious and important.").verbatim(false)))
                .level("info"));
        return block;
    }
}
