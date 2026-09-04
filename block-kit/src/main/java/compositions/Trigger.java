package compositions;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.WorkflowObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Defines an object containing trigger information.
 * {@link https://docs.slack.dev/reference/block-kit/composition-objects/trigger-object/}
 */
public class Trigger {
    /**
     * A section block with a workflow button whose trigger carries customizable input parameters.
     */
    public static SectionBlock example01() {
        SectionBlock block = Blocks.section(s -> s.text(
                        BlockCompositions.markdownText("A message *with some bold text* and _some italicized text_."))
                .accessory(BlockElements.workflowButton(w -> w.text(BlockCompositions.plainText("Run Workflow"))
                        .actionId("workflowbutton123")
                        .workflow(WorkflowObject.builder()
                                .trigger(WorkflowObject.Trigger.builder()
                                        .url("https://slack.com/shortcuts/Ft0123ABC456/xyz...zyx")
                                        .customizableInputParameters(List.of(
                                                WorkflowObject.Trigger.InputParameter.builder()
                                                        .name("input_parameter_a")
                                                        .value("Value for input param A")
                                                        .build(),
                                                WorkflowObject.Trigger.InputParameter.builder()
                                                        .name("input_parameter_b")
                                                        .value("Value for input param B")
                                                        .build()))
                                        .build())
                                .build()))));
        return block;
    }
}
