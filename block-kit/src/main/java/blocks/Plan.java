package blocks;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.PlanBlock;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.util.List;

/**
 * Displays a collection of related tasks.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/plan-block/}
 */
public class Plan {
    /**
     * A plan block with multiple task cards in various states.
     */
    public static PlanBlock example01() {
        PlanBlock block = Blocks.plan(p -> p.title("Thinking completed")
                .tasks(List.of(
                        Blocks.taskCard(t -> t.taskId("call_001")
                                .title("Fetched user profile information")
                                .status("in_progress")
                                .details(RichTextBlock.builder()
                                        .blockId("viMWO")
                                        .elements(List.of(RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Searched database...")
                                                        .build()))
                                                .build()))
                                        .build())
                                .output(RichTextBlock.builder()
                                        .blockId("viMWO")
                                        .elements(List.of(RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("Profile data loaded")
                                                        .build()))
                                                .build()))
                                        .build())),
                        Blocks.taskCard(t -> t.taskId("call_002")
                                .title("Checked user permissions")
                                .status("in_progress")),
                        Blocks.taskCard(t -> t.taskId("call_003")
                                .title("Generated comprehensive user report")
                                .status("complete")
                                .output(RichTextBlock.builder()
                                        .blockId("crsk")
                                        .elements(List.of(RichTextSectionElement.builder()
                                                .elements(List.of(RichTextSectionElement.Text.builder()
                                                        .text("15 data points compiled")
                                                        .build()))
                                                .build()))
                                        .build())))));
        return block;
    }
}
