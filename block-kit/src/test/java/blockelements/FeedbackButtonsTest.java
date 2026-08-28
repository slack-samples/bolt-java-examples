package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class FeedbackButtonsTest {
    @Test
    public void testExample01() {
        ContextActionsBlock block = FeedbackButtons.example01();
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
                      "text": "Good"
                    },
                    "value": "positive_feedback",
                    "accessibility_label": "Mark this response as good"
                  },
                  "negative_button": {
                    "text": {
                      "type": "plain_text",
                      "text": "Bad"
                    },
                    "value": "negative_feedback",
                    "accessibility_label": "Mark this response as bad"
                  }
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
