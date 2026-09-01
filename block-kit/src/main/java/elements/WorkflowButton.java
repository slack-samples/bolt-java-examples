package elements;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.WorkflowObject;
import com.slack.api.model.block.element.BlockElements;
import java.util.List;

/**
 * Allows users to run a link trigger with customizable inputs.
 * {@link https://docs.slack.dev/reference/block-kit/block-elements/workflow-button-element/}
 */
public class WorkflowButton {
    /**
     * A section block containing a workflow button element.
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
