package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.view.View;
import com.slack.api.model.view.ViewClose;
import com.slack.api.model.view.ViewSubmit;
import com.slack.api.model.view.ViewTitle;
import java.util.List;

/**
 * Allows users to choose multiple items from a list of options.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/checkboxes-element/}
 */
public class Checkboxes {
    /**
     * A section block containing a group of checkboxes.
     */
    public static View example01() {
        View view = View.builder()
                .type("modal")
                .title(ViewTitle.builder()
                        .type("plain_text")
                        .text("My App")
                        .emoji(true)
                        .build())
                .submit(ViewSubmit.builder()
                        .type("plain_text")
                        .text("Submit")
                        .emoji(true)
                        .build())
                .close(ViewClose.builder()
                        .type("plain_text")
                        .text("Cancel")
                        .emoji(true)
                        .build())
                .blocks(List.of(Blocks.section(s -> s.text(
                                BlockCompositions.plainText("Check out these charming checkboxes"))
                        .accessory(BlockElements.checkboxes(c -> c.actionId("this_is_an_action_id")
                                .initialOptions(List.of(OptionObject.builder()
                                        .value("A1")
                                        .text(BlockCompositions.plainText("Checkbox 1"))
                                        .build()))
                                .options(List.of(
                                        OptionObject.builder()
                                                .value("A1")
                                                .text(BlockCompositions.plainText("Checkbox 1"))
                                                .build(),
                                        OptionObject.builder()
                                                .value("A2")
                                                .text(BlockCompositions.plainText("Checkbox 2"))
                                                .description(
                                                        BlockCompositions.markdownText("*A description of option two*"))
                                                .build())))))))
                .build();
        return view;
    }
}
