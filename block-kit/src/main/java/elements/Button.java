package elements;

import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ButtonElement;
import java.util.List;

/**
 * Allows users a direct path to performing basic actions.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/button-element/}
 */
public class Button {
    /**
     * A regular interactive button.
     */
    public static ButtonElement example01() {
        ButtonElement element = BlockElements.button(
                b -> b.text(plainText("Click Me")).value("click_me_123").actionId("button"));
        return element;
    }

    /**
     * A button with a primary style attribute.
     */
    public static ButtonElement example02() {
        ButtonElement element = BlockElements.button(b ->
                b.text(plainText("Save")).style("primary").value("click_me_123").actionId("button"));
        return element;
    }

    /**
     * A link button.
     */
    public static ButtonElement example03() {
        ButtonElement element =
                BlockElements.button(b -> b.text(plainText("Link Button")).url("https://docs.slack.dev/block-kit"));
        return element;
    }

    /**
     * The button element used inside either the section or actions block.
     */
    public static List<LayoutBlock> example05() {
        List<LayoutBlock> blocks = List.of(
                Blocks.section(s -> s.text(markdownText("This is a section block with a button."))
                        .accessory(BlockElements.button(b -> b.text(plainText("Click Me"))
                                .value("click_me_123")
                                .actionId("button")))),
                Blocks.actions(a -> a.blockId("actionblock789")
                        .elements(List.of(
                                BlockElements.button(b -> b.text(plainText("Primary Button"))
                                        .style("primary")
                                        .value("click_me_456")),
                                BlockElements.button(b ->
                                        b.text(plainText("Link Button")).url("https://api.slack.com/block-kit"))))));
        return blocks;
    }
}
