package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ContextActionsTest {
    @Test
    public void testExample01() {
        ContextActionsBlock block = ContextActions.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "context_actions",
              "elements": [
                {
                  "type": "feedback_buttons",
                  "action_id": "feedback_buttons_1",
                  "positive_button": {
                    "text": {
                      "type": "plain_text",
                      "text": "👍"
                    },
                    "value": "positive_feedback"
                  },
                  "negative_button": {
                    "text": {
                      "type": "plain_text",
                      "text": "👎"
                    },
                    "value": "negative_feedback"
                  }
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        ContextActionsBlock block = ContextActions.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "context_actions",
              "elements": [
                {
                  "type": "icon_button",
                  "icon": "trash",
                  "text": {
                    "type": "plain_text",
                    "text": "Delete"
                  },
                  "action_id": "delete_button_1",
                  "value": "delete_item"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
