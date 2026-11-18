package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.TaskCardBlock;
import com.slack.api.model.block.element.UrlSourceElement;
import java.util.List;

/**
 * Displays a URL source for referencing within a task card block.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/url-source-element/}
 */
public class UrlSource {
    /**
     * A URL source element.
     */
    public static UrlSourceElement example01() {
        UrlSourceElement element = UrlSourceElement.builder()
                .url("https://docs.slack.dev/")
                .text("Slack API docs")
                .build();
        return element;
    }

    /**
     * A task card block with URL source elements.
     */
    public static TaskCardBlock example02() {
        TaskCardBlock block = Blocks.taskCard(t -> t.taskId("task_1")
                .title("Scientific findings")
                .status("complete")
                .sources(List.of(
                        UrlSourceElement.builder()
                                .url("https://docs.example.com/")
                                .text("Tracy's delightful docs")
                                .build(),
                        UrlSourceElement.builder()
                                .url("https://research.example.com/")
                                .text("Haley's resourceful research")
                                .build())));
        return block;
    }
}
