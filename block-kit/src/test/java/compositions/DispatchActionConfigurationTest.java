package compositions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DispatchActionConfigurationTest {
    @Test
    public void testExample01() {
        InputBlock block = DispatchActionConfiguration.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "input",
              "dispatch_action": true,
              "element": {
                "type": "plain_text_input",
                "multiline": true,
                "dispatch_action_config": {
                  "trigger_actions_on": [
                    "on_character_entered"
                  ]
                }
              },
              "label": {
                "type": "plain_text",
                "text": "This is a multiline plain-text input",
                "emoji": true
              },
              "optional": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
