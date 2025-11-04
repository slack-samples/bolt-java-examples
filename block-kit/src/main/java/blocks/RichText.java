package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextListElement;
import com.slack.api.model.block.element.RichTextPreformattedElement;
import com.slack.api.model.block.element.RichTextQuoteElement;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.RichTextSectionElement.TextStyle;
import java.util.List;

/**
 * Displays formatted, structured representation of text.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/rich-text-block/}
 */
public class RichText {
    /**
     * Four basic rich text section examples (basic, bold, italic, strikethrough).
     */
    public static List<RichTextBlock> example01() {
        List<RichTextBlock> blocks = List.of(
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(RichTextSectionElement.Text.builder()
                                .text("Hello there, I am a basic rich text block!")
                                .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am a bold rich text block!")
                                        .style(TextStyle.builder().bold(true).build())
                                        .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am an italic rich text block!")
                                        .style(TextStyle.builder().italic(true).build())
                                        .build()))
                        .build()))),
                Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                        .elements(List.of(
                                RichTextSectionElement.Text.builder()
                                        .text("Hello there, ")
                                        .build(),
                                RichTextSectionElement.Text.builder()
                                        .text("I am a strikethrough rich text block!")
                                        .style(TextStyle.builder().strike(true).build())
                                        .build()))
                        .build()))));
        return blocks;
    }

    /**
     * A rich text block with a bullet list.
     */
    public static RichTextBlock example02() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("block1")
                .elements(List.of(
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("My favorite Slack features (in no particular order):")
                                        .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .indent(0)
                                .border(1)
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Huddles")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Canvas")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Developing with Block Kit")
                                                        .build()))
                                                .build()))
                                .build())));
        return block;
    }

    /**
     * A rich text block with a nested bullet list.
     */
    public static RichTextBlock example03() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("block1")
                .elements(List.of(
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("Breakfast foods I enjoy:")
                                        .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Hashbrowns")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Eggs")
                                                        .build()))
                                                .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .indent(1)
                                .elements(List.of(
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Scrambled")
                                                        .build()))
                                                .build(),
                                        RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Over easy")
                                                        .build()))
                                                .build()))
                                .build(),
                        RichTextListElement.builder()
                                .style("bullet")
                                .elements(List.of(RichTextSectionElement.builder()
                                        .elements(List.of(RichTextSectionElement.Text.builder()
                                                .text("Pancakes, extra syrup")
                                                .build()))
                                        .build()))
                                .build())));
        return block;
    }

    /**
     * A rich text block with preformatted code.
     */
    public static RichTextBlock example04() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextPreformattedElement.builder()
                .border(0)
                .elements(List.of(RichTextSectionElement.Text.builder()
                        .text(
                                "{\n  \"object\": {\n    \"description\": \"this is an example of a json object\"\n  }\n}")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a quote.
     */
    public static RichTextBlock example05() {
        RichTextBlock block = Blocks.richText(rt -> rt.blockId("Vrzsu")
                .elements(List.of(
                        RichTextQuoteElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("What we need is good examples in our documentation.")
                                        .build()))
                                .build(),
                        RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("Yes - I completely agree, Luke!")
                                        .build()))
                                .build())));
        return block;
    }

    /**
     * A rich text block with a broadcast element.
     */
    public static RichTextBlock example06() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Broadcast.builder()
                        .range("everyone")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a color element.
     */
    public static RichTextBlock example07() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(
                        RichTextSectionElement.Color.builder().value("#F405B3").build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a channel element.
     */
    public static RichTextBlock example08() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Channel.builder()
                        .channelId("C123ABC456")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a date element.
     */
    public static RichTextBlock example09() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Date.builder()
                        .timestamp(1720710212)
                        .format("{date_num} at {time}")
                        .fallback("timey")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with emoji elements.
     */
    public static RichTextBlock example10() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(
                        RichTextSectionElement.Emoji.builder()
                                .name("basketball")
                                .build(),
                        RichTextSectionElement.Text.builder().text(" ").build(),
                        RichTextSectionElement.Emoji.builder()
                                .name("snowboarder")
                                .build(),
                        RichTextSectionElement.Text.builder().text(" ").build(),
                        RichTextSectionElement.Emoji.builder()
                                .name("checkered_flag")
                                .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a link element.
     */
    public static RichTextBlock example11() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.Link.builder()
                        .url("https://api.slack.com")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a user mention element.
     */
    public static RichTextBlock example12() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.User.builder()
                        .userId("U123ABC456")
                        .build()))
                .build())));
        return block;
    }

    /**
     * A rich text block with a usergroup mention element.
     */
    public static RichTextBlock example13() {
        RichTextBlock block = Blocks.richText(rt -> rt.elements(List.of(RichTextSectionElement.builder()
                .elements(List.of(RichTextSectionElement.UserGroup.builder()
                        .usergroupId("G123ABC456")
                        .build()))
                .build())));
        return block;
    }
}
