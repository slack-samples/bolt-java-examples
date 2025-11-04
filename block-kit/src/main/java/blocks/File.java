package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.FileBlock;

/**
 * Displays info about remote files.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/file-block/}
 */
public class File {
    /**
     * A file block for a remote file.
     */
    public static FileBlock example01() {
        FileBlock block = Blocks.file(f -> f.externalId("ABCD1").source("remote"));
        return block;
    }
}
