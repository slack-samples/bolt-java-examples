package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ImageBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.SlackFileObject;

/**
 * Displays an image.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/image-block/}
 */
public class Image {
    /**
     * An image block using image_url.
     */
    public static ImageBlock example01() {
        ImageBlock block = Blocks.image(i -> i.title(BlockCompositions.plainText("Please enjoy this photo of a kitten"))
                .blockId("image4")
                .imageUrl("http://placekitten.com/500/500")
                .altText("An incredibly cute kitten."));
        return block;
    }

    /**
     * An image block using slack_file with a url.
     */
    public static ImageBlock example02() {
        ImageBlock block = Blocks.image(i -> i.title(BlockCompositions.plainText("Please enjoy this photo of a kitten"))
                .blockId("image4")
                .slackFile(SlackFileObject.builder()
                        .url("https://files.slack.com/files-pri/T0123456-F0123456/xyz.png")
                        .build())
                .altText("An incredibly cute kitten."));
        return block;
    }

    /**
     * An image block using slack_file with an id.
     */
    public static ImageBlock example03() {
        ImageBlock block = Blocks.image(i -> i.title(BlockCompositions.plainText("Please enjoy this photo of a kitten"))
                .blockId("image4")
                .slackFile(SlackFileObject.builder().id("F0123456").build())
                .altText("An incredibly cute kitten."));
        return block;
    }
}
