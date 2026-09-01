package compositions;

import static com.slack.api.model.block.composition.BlockCompositions.plainText;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.element.BlockElements;
import com.slack.api.model.block.element.ConversationsFilter;
import com.slack.api.model.view.View;
import com.slack.api.model.view.ViewClose;
import com.slack.api.model.view.ViewSubmit;
import com.slack.api.model.view.ViewTitle;
import java.util.List;

/**
 * Defines a filter for the list of options in a conversation selector menu.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/conversation-filter-object/}
 */
public class ConversationFilter {
    /**
     * A modal view with a conversations select input carrying a filter.
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
                .blocks(List.of(
                        Blocks.input(i -> i.element(BlockElements.conversationsSelect(c -> c.placeholder(plainText(pt ->
                                                pt.text("Select a conversation").emoji(true)))
                                        .filter(ConversationsFilter.builder()
                                                .include(List.of("public", "mpim"))
                                                .excludeBotUsers(true)
                                                .build())))
                                .label(plainText(l -> l.text("Choose the conversation to publish your result to:")
                                        .emoji(true))))))
                .build();
        return view;
    }
}
