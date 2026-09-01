package elements;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.view.View;
import com.slack.api.model.view.Views;
import java.util.List;

/**
 * Allows user to upload files.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/file-input-element/}
 */
public class FileInput {
    /**
     * A modal view with a file input element hosted in an input block.
     */
    public static View example01() {
        View view = Views.view(v -> v.type("modal")
                .title(Views.viewTitle(t -> t.type("plain_text").text("My App").emoji(true)))
                .submit(Views.viewSubmit(
                        s -> s.type("plain_text").text("Submit").emoji(true)))
                .close(Views.viewClose(c -> c.type("plain_text").text("Cancel").emoji(true)))
                .blocks(List.of(Blocks.input(i -> i.blockId("input_block_id")
                        .label(plainText("Upload Files"))
                        .element(BlockElements.fileInput(f -> f.actionId("file_input_action_id_1")
                                .filetypes(List.of("jpg", "png"))
                                .maxFiles(5)))))));
        return view;
    }
}
