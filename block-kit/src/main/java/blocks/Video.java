package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.VideoBlock;
import com.slack.api.model.block.composition.BlockCompositions;

/**
 * Displays an embedded video player.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/video-block/}
 */
public class Video {
    /**
     * A video block.
     */
    public static VideoBlock example01() {
        VideoBlock block = Blocks.video(v -> v.title(
                        BlockCompositions.plainText(pt -> pt.text("Use the Events API to create a dynamic App Home")
                                .emoji(true)))
                .titleUrl("https://www.youtube.com/watch?v=8876OZV_Yy0")
                .description(BlockCompositions.plainText(
                        pt -> pt.text("Slack sure is nifty!").emoji(true)))
                .videoUrl("https://www.youtube.com/embed/8876OZV_Yy0?feature=oembed&autoplay=1")
                .altText("Use the Events API to create a dynamic App Home")
                .thumbnailUrl("https://i.ytimg.com/vi/8876OZV_Yy0/hqdefault.jpg"));
        return block;
    }
}
