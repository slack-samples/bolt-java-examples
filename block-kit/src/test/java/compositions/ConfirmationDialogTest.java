package compositions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ActionsBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ConfirmationDialogTest {
    @Test
    public void testExample01() {
        ActionsBlock block = ConfirmationDialog.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "actions",
              "elements": [
                {
                  "type": "button",
                  "text": {
                    "type": "plain_text",
                    "emoji": true,
                    "text": "Approve"
                  },
                  "confirm": {
                    "title": {
                      "type": "plain_text",
                      "text": "Are you sure?"
                    },
                    "text": {
                      "type": "mrkdwn",
                      "text": "Would you not prefer a good game of _chess_?"
                    },
                    "confirm": {
                      "type": "plain_text",
                      "text": "Do it"
                    },
                    "deny": {
                      "type": "plain_text",
                      "text": "Stop, I changed my mind!"
                    }
                  },
                  "style": "primary",
                  "value": "click_me_123"
                },
                {
                  "type": "button",
                  "text": {
                    "type": "plain_text",
                    "emoji": true,
                    "text": "Deny"
                  },
                  "style": "danger",
                  "value": "click_me_123"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
