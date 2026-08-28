package compositionobjects;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;

/**
 * Defines an object containing some text.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/text-object/}
 */
public class Text {
    /**
     * A section block hosting an mrkdwn text object.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(
                s -> s.text(markdownText("A message *with some bold text* and _some italicized text_.")));
        return block;
    }
}
