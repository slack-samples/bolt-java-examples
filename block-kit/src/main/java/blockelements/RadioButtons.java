package blockelements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to choose one item from a list of possible options.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/radio-button-group-element/}
 */
public class RadioButtons {
    /**
     * A section block with a radio button group accessory.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.text(plainText("Check out these rad radio buttons"))
                .accessory(BlockElements.radioButtons(r -> r.actionId("this_is_an_action_id")
                        .initialOption(OptionObject.builder()
                                .value("A1")
                                .text(plainText("Radio 1"))
                                .build())
                        .options(List.of(
                                OptionObject.builder()
                                        .value("A1")
                                        .text(plainText("Radio 1"))
                                        .build(),
                                OptionObject.builder()
                                        .value("A2")
                                        .text(plainText("Radio 2"))
                                        .build())))));
        return block;
    }
}
