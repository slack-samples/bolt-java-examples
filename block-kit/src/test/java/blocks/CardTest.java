package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.CardBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    public void testExample01() {
        CardBlock block = Card.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "card",
              "icon": {
                "type": "image",
                "image_url": "https://picsum.photos/36/36",
                "alt_text": "Icon"
              },
              "title": {
                "type": "mrkdwn",
                "text": "Lumon Industries"
              },
              "subtitle": {
                "type": "mrkdwn",
                "text": "Committed to work-life balance"
              },
              "hero_image": {
                "type": "image",
                "image_url": "https://picsum.photos/400/300",
                "alt_text": "Sample hero image"
              },
              "body": {
                "type": "mrkdwn",
                "text": "Please enjoy each card equally."
              },
              "actions": [
                {
                  "type": "button",
                  "text": {
                    "type": "plain_text",
                    "text": "Action Button",
                    "emoji": false
                  },
                  "action_id": "button_action"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
