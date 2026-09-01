package compositions;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.ImageBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.SlackFileObject;

/**
 * Defines an object containing Slack file information to be used in an image block or image element.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/slack-file-object/}
 */
public class SlackFile {
    /**
     * An image block referencing a Slack file by url.
     */
    public static ImageBlock example01() {
        ImageBlock block = Blocks.image(i -> i.title(BlockCompositions.plainText("Please enjoy this photo of a kitten"))
                .blockId("image4")
                .slackFile(SlackFileObject.builder()
                        .url("https://files.slack.com/files-pri/T0123456-F0123456/xyz.png")
                        .build())
                .altText("An incredibly cute kitten."));
        return block;
    }

    /**
     * An image block referencing a Slack file by id.
     */
    public static ImageBlock example02() {
        ImageBlock block = Blocks.image(i -> i.title(BlockCompositions.plainText("Please enjoy this photo of a kitten"))
                .blockId("image4")
                .slackFile(SlackFileObject.builder().id("F0123456").build())
                .altText("An incredibly cute kitten."));
        return block;
    }
}
