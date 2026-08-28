package compositionobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.view.View;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ConversationFilterTest {
    @Test
    public void testExample01() {
        View view = ConversationFilter.example01();
        String actual = GsonFactory.createSnakeCase().toJson(view);
        String expected = """
            {
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
              "type": "modal",
              "close": {
                "type": "plain_text",
                "text": "Cancel",
                "emoji": true
              },
              "blocks": [
                {
                  "type": "input",
                  "element": {
                    "type": "conversations_select",
                    "placeholder": {
                      "type": "plain_text",
                      "text": "Select a conversation",
                      "emoji": true
                    },
                    "filter": {
                      "include": [
                        "public",
                        "mpim"
                      ],
                      "exclude_bot_users": true
                    }
                  },
                  "label": {
                    "type": "plain_text",
                    "text": "Choose the conversation to publish your result to:",
                    "emoji": true
                  },
                  "optional": false
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
