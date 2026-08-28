package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RichTextInputTest {
    @Test
    public void testExample01() {
        InputBlock block = RichTextInput.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "input",
              "element": {
                "type": "rich_text_input",
                "action_id": "rich_text_input-action",
                "dispatch_action_config": {
                  "trigger_actions_on": [
                    "on_character_entered"
                  ]
                },
                "focus_on_load": true,
                "placeholder": {
                  "type": "plain_text",
                  "text": "Enter text"
                }
              },
              "label": {
                "type": "plain_text",
                "text": "Label",
                "emoji": true
              },
              "optional": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
