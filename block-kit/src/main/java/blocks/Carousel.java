package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.CarouselBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Displays a horizontally scrollable collection of cards.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/carousel-block/}
 */
public class Carousel {
    /**
     * A carousel with three cards.
     */
    public static CarouselBlock example01() {
        CarouselBlock block = Blocks.carousel(c -> c.elements(List.of(
                Blocks.card(card -> card.blockId("carousel-card-1")
                        .icon(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/36/36").altText("Icon")))
                        .title(BlockCompositions.markdownText("MDR"))
                        .subtitle(BlockCompositions.markdownText("Refining data files"))
                        .heroImage(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/400/300").altText("Sample hero image")))
                        .body(BlockCompositions.markdownText("Blue badge required to gain access."))
                        .actions(List.of(BlockElements.button(b -> b.text(BlockCompositions.plainText(
                                        pt -> pt.text("Action Button").emoji(false)))
                                .actionId("button_action_1"))))),
                Blocks.card(card -> card.blockId("carousel-card-2")
                        .icon(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/36/36").altText("Icon")))
                        .title(BlockCompositions.markdownText("O&D"))
                        .subtitle(BlockCompositions.markdownText("Storage, maintenance, and rotation of art pieces"))
                        .heroImage(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/400/300").altText("Sample hero image")))
                        .body(BlockCompositions.markdownText("Green badge required to gain access."))
                        .actions(List.of(BlockElements.button(b -> b.text(BlockCompositions.plainText(
                                        pt -> pt.text("Action Button").emoji(false)))
                                .actionId("button_action_2"))))),
                Blocks.card(card -> card.blockId("carousel-card-3")
                        .icon(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/36/36").altText("Icon")))
                        .title(BlockCompositions.markdownText("Wellness Center"))
                        .subtitle(BlockCompositions.markdownText("Wellness sessions"))
                        .heroImage(BlockElements.imageElement(
                                i -> i.imageUrl("https://picsum.photos/400/300").altText("Sample hero image")))
                        .body(BlockCompositions.markdownText("Please take a seat in the waiting room until called."))
                        .actions(List.of(BlockElements.button(b -> b.text(BlockCompositions.plainText(
                                        pt -> pt.text("Action Button").emoji(false)))
                                .actionId("button_action_3"))))))));
        return block;
    }
}
