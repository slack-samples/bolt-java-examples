package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class WorkflowButtonTest {
    @Test
    public void testExample01() {
        SectionBlock block = WorkflowButton.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "text": {
                "text": "A message *with some bold text* and _some italicized text_.",
                "type": "mrkdwn"
              },
              "accessory": {
                "type": "workflow_button",
                "text": {
                  "type": "plain_text",
                  "text": "Run Workflow"
                },
                "action_id": "workflowbutton123",
                "workflow": {
                  "trigger": {
                    "url": "https://slack.com/shortcuts/Ft0123ABC456/xyz...zyx",
                    "customizable_input_parameters": [
                      {
                        "name": "input_parameter_a",
                        "value": "Value for input param A"
                      },
                      {
                        "name": "input_parameter_b",
                        "value": "Value for input param B"
                      }
                    ]
                  }
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
