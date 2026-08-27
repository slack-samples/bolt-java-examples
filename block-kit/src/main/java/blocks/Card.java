package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.CardBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Displays a card layout with optional icon, title, body, and actions.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/card-block/}
 */
public class Card {
    /**
     * A card with icon, title, subtitle, hero image, body, and an action button.
     */
    public static CardBlock example01() {
        CardBlock block = Blocks.card(c -> c.icon(BlockElements.imageElement(
                        i -> i.imageUrl("https://picsum.photos/36/36").altText("Icon")))
                .title(BlockCompositions.markdownText("Lumon Industries"))
                .subtitle(BlockCompositions.markdownText("Committed to work-life balance"))
                .heroImage(BlockElements.imageElement(
                        i -> i.imageUrl("https://picsum.photos/400/300").altText("Sample hero image")))
                .body(BlockCompositions.markdownText("Please enjoy each card equally."))
                .actions(List.of(BlockElements.button(b -> b.text(BlockCompositions.plainText(
                                pt -> pt.text("Action Button").emoji(false)))
                        .actionId("button_action")))));
        return block;
    }
}
