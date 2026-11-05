package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class OverflowMenuTest {
    @Test
    public void testExample01() {
        SectionBlock block = OverflowMenu.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section 890",
              "text": {
                "type": "mrkdwn",
                "text": "This is a section block with an overflow menu."
              },
              "accessory": {
                "type": "overflow",
                "action_id": "overflow",
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
                  },
                  {
                    "text": {
                      "type": "plain_text",
                      "text": "*this is plain_text text*"
                    },
                    "value": "value-3"
                  },
                  {
                    "text": {
                      "type": "plain_text",
                      "text": "*this is plain_text text*"
                    },
                    "value": "value-4"
                  }
                ]
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
