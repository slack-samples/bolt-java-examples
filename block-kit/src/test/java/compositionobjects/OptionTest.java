package compositionobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.util.json.GsonFactory;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OptionTest {
    @Test
    public void testExample01() {
        OptionObject option = Option.example01();
        String actual = GsonFactory.createSnakeCase().toJson(option);
        String expected = """
            {
              "text": {
                "type": "plain_text",
                "emoji": true,
                "text": "Save it"
              },
              "value": "value-2"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        List<LayoutBlock> blocks = Option.example02();
        String actual = GsonFactory.createSnakeCase().toJson(blocks);
        String expected = """
            [
              {
                "type": "section",
                "text": {
                  "type": "mrkdwn",
                  "text": ":mag: Search results for *Cata*"
                }
              },
              {
                "type": "divider"
              },
              {
                "type": "section",
                "text": {
                  "type": "mrkdwn",
                  "text": "*<fakeLink.toYourApp.com|Use Case Catalogue>*\\nUse Case Catalogue for the following departments/roles..."
                },
                "accessory": {
                  "type": "static_select",
                  "placeholder": {
                    "type": "plain_text",
                    "emoji": true,
                    "text": "Manage"
                  },
                  "options": [
                    {
                      "text": {
                        "type": "plain_text",
                        "emoji": true,
                        "text": "Edit it"
                      },
                      "value": "value-0"
                    },
                    {
                      "text": {
                        "type": "plain_text",
                        "emoji": true,
                        "text": "Read it"
                      },
                      "value": "value-1"
                    },
                    {
                      "text": {
                        "type": "plain_text",
                        "emoji": true,
                        "text": "Save it"
                      },
                      "value": "value-2"
                    }
                  ]
                }
              }
            ]
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
