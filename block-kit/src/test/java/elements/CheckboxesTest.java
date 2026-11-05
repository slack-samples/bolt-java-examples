package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.view.View;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class CheckboxesTest {
    @Test
    public void testExample01() {
        View view = Checkboxes.example01();
        String actual = GsonFactory.createSnakeCase().toJson(view);
        String expected = """
            {
              "type": "modal",
              "title": {
                "type": "plain_text",
                "text": "My App",
                "emoji": true
              },
              "submit": {
                "type": "plain_text",
                "text": "Submit",
                "emoji": true
              },
              "close": {
                "type": "plain_text",
                "text": "Cancel",
                "emoji": true
              },
              "blocks": [
                {
                  "type": "section",
                  "text": {
                    "type": "plain_text",
                    "text": "Check out these charming checkboxes"
                  },
                  "accessory": {
                    "type": "checkboxes",
                    "action_id": "this_is_an_action_id",
                    "initial_options": [
                      {
                        "value": "A1",
                        "text": {
                          "type": "plain_text",
                          "text": "Checkbox 1"
                        }
                      }
                    ],
                    "options": [
                      {
                        "value": "A1",
                        "text": {
                          "type": "plain_text",
                          "text": "Checkbox 1"
                        }
                      },
                      {
                        "value": "A2",
                        "text": {
                          "type": "plain_text",
                          "text": "Checkbox 2"
                        },
                        "description": {
                          "type": "mrkdwn",
                          "text": "*A description of option two*"
                        }
                      }
                    ]
                  }
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
