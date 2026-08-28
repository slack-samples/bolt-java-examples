package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.element.ButtonElement;
import com.slack.api.util.json.GsonFactory;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ButtonTest {
    @Test
    public void testExample01() {
        ButtonElement element = Button.example01();
        String actual = GsonFactory.createSnakeCase().toJson(element);
        String expected = """
            {
              "type": "button",
              "text": {
                "type": "plain_text",
                "text": "Click Me"
              },
              "value": "click_me_123",
              "action_id": "button"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        ButtonElement element = Button.example02();
        String actual = GsonFactory.createSnakeCase().toJson(element);
        String expected = """
            {
              "type": "button",
              "text": {
                "type": "plain_text",
                "text": "Save"
              },
              "style": "primary",
              "value": "click_me_123",
              "action_id": "button"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        ButtonElement element = Button.example03();
        String actual = GsonFactory.createSnakeCase().toJson(element);
        String expected = """
            {
              "type": "button",
              "text": {
                "type": "plain_text",
                "text": "Link Button"
              },
              "url": "https://docs.slack.dev/block-kit"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample04() {
        List<LayoutBlock> blocks = Button.example04();
        String actual = GsonFactory.createSnakeCase().toJson(blocks);
        String expected = """
            [
              {
                "type": "section",
                "text": {
                  "type": "mrkdwn",
                  "text": "This is a section block with a button."
                },
                "accessory": {
                  "type": "button",
                  "text": {
                    "type": "plain_text",
                    "text": "Click Me"
                  },
                  "value": "click_me_123",
                  "action_id": "button"
                }
              },
              {
                "type": "actions",
                "block_id": "actionblock789",
                "elements": [
                  {
                    "type": "button",
                    "text": {
                      "type": "plain_text",
                      "text": "Primary Button"
                    },
                    "style": "primary",
                    "value": "click_me_456"
                  },
                  {
                    "type": "button",
                    "text": {
                      "type": "plain_text",
                      "text": "Link Button"
                    },
                    "url": "https://api.slack.com/block-kit"
                  }
                ]
              }
            ]
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
