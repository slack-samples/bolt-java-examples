package compositions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.util.json.GsonFactory;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OptionGroupTest {
    @Test
    public void testExample01() {
        List<LayoutBlock> blocks = OptionGroup.example01();
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
                  "option_groups": [
                    {
                      "label": {
                        "type": "plain_text",
                        "text": "Group 1"
                      },
                      "options": [
                        {
                          "text": {
                            "type": "plain_text",
                            "text": "*this is plain_text text*"
                          },
                          "value": "value-0"
                        },
                        {
                          "text": {
                            "type": "plain_text",
                            "text": "*this is plain_text text*"
                          },
                          "value": "value-1"
                        },
                        {
                          "text": {
                            "type": "plain_text",
                            "text": "*this is plain_text text*"
                          },
                          "value": "value-2"
                        }
                      ]
                    },
                    {
                      "label": {
                        "type": "plain_text",
                        "text": "Group 2"
                      },
                      "options": [
                        {
                          "text": {
                            "type": "plain_text",
                            "text": "*this is plain_text text*"
                          },
                          "value": "value-3"
                        }
                      ]
                    }
                  ]
                }
              }
            ]
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
