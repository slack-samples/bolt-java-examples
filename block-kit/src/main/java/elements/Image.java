package elements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.SlackFileObject;
import com.slack.api.model.block.element.BlockElements;

/**
 * Displays an image as part of a larger block of content.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/image-element/}
 */
public class Image {
    /**
     * A section block with an image accessory using image_url.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.blockId("section567")
                .text(markdownText("This is a section block with an accessory image."))
                .accessory(BlockElements.image(
                        i -> i.imageUrl("https://pbs.twimg.com/profile_images/625633822235693056/lNGUneLX_400x400.jpg")
                                .altText("cute cat"))));
        return block;
    }

    /**
     * A section block with an image accessory using a slack_file url.
     */
    public static SectionBlock example02() {
        SectionBlock block = Blocks.section(s -> s.blockId("section567")
                .text(markdownText("This is a section block with an accessory image."))
                .accessory(BlockElements.image(i -> i.slackFile(SlackFileObject.builder()
                                .url("https://files.slack.com/files-pri/T0123456-F0123456/xyz.png")
                                .build())
                        .altText("Slack file object."))));
        return block;
    }

    /**
     * A section block with an image accessory using a slack_file id.
     */
    public static SectionBlock example03() {
        SectionBlock block = Blocks.section(s -> s.blockId("section567")
                .text(markdownText("This is a section block with an accessory image."))
                .accessory(BlockElements.image(i -> i.slackFile(
                                SlackFileObject.builder().id("F01234567").build())
                        .altText("Slack file object."))));
        return block;
    }
}
