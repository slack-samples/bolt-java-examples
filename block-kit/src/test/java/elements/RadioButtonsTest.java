package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RadioButtonsTest {
    @Test
    public void testExample01() {
        SectionBlock block = RadioButtons.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "text": {
                "type": "plain_text",
                "text": "Check out these rad radio buttons"
              },
              "accessory": {
                "type": "radio_buttons",
                "action_id": "this_is_an_action_id",
                "initial_option": {
                  "value": "A1",
                  "text": {
                    "type": "plain_text",
                    "text": "Radio 1"
                  }
                },
                "options": [
                  {
                    "value": "A1",
                    "text": {
                      "type": "plain_text",
                      "text": "Radio 1"
                    }
                  },
                  {
                    "value": "A2",
                    "text": {
                      "type": "plain_text",
                      "text": "Radio 2"
                    }
                  }
                ]
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
