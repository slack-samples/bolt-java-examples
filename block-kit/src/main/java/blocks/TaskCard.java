package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.TaskCardBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import com.slack.api.model.block.element.UrlSourceElement;
import java.util.List;

/**
 * Displays a single task, representing a single action.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/task-card-block/}
 */
public class TaskCard {
    /**
     * A task card with output and sources.
     */
    public static TaskCardBlock example01() {
        TaskCardBlock block = Blocks.taskCard(t -> t.taskId("task_1")
                .title("Fetching weather data")
                .status("in_progress")
                .output(RichTextBlock.builder()
                        .elements(List.of(RichTextSectionElement.builder()
                                .elements(List.of(RichTextSectionElement.Text.builder()
                                        .text("Found weather data for Chicago from 2 sources")
                                        .build()))
                                .build()))
                        .build())
                .sources(List.of(
                        UrlSourceElement.builder()
                                .url("https://weather.com/")
                                .text("weather.com")
                                .build(),
                        UrlSourceElement.builder()
                                .url("https://www.accuweather.com/")
                                .text("accuweather.com")
                                .build())));
        return block;
    }
}
