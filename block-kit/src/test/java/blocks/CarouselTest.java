package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.CarouselBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class CarouselTest {
    @Test
    public void testExample01() {
        CarouselBlock block = Carousel.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "carousel",
              "elements": [
                {
                  "type": "card",
                  "block_id": "carousel-card-1",
                  "icon": {
                    "type": "image",
                    "image_url": "https://picsum.photos/36/36",
                    "alt_text": "Icon"
                  },
                  "title": {
                    "type": "mrkdwn",
                    "text": "MDR"
                  },
                  "subtitle": {
                    "type": "mrkdwn",
                    "text": "Refining data files"
                  },
                  "hero_image": {
                    "type": "image",
                    "image_url": "https://picsum.photos/400/300",
                    "alt_text": "Sample hero image"
                  },
                  "body": {
                    "type": "mrkdwn",
                    "text": "Blue badge required to gain access."
                  },
                  "actions": [
                    {
                      "type": "button",
                      "text": {
                        "type": "plain_text",
                        "text": "Action Button",
                        "emoji": false
                      },
                      "action_id": "button_action_1"
                    }
                  ]
                },
                {
                  "type": "card",
                  "block_id": "carousel-card-2",
                  "icon": {
                    "type": "image",
                    "image_url": "https://picsum.photos/36/36",
                    "alt_text": "Icon"
                  },
                  "title": {
                    "type": "mrkdwn",
                    "text": "O&D"
                  },
                  "subtitle": {
                    "type": "mrkdwn",
                    "text": "Storage, maintenance, and rotation of art pieces"
                  },
                  "hero_image": {
                    "type": "image",
                    "image_url": "https://picsum.photos/400/300",
                    "alt_text": "Sample hero image"
                  },
                  "body": {
                    "type": "mrkdwn",
                    "text": "Green badge required to gain access."
                  },
                  "actions": [
                    {
                      "type": "button",
                      "text": {
                        "type": "plain_text",
                        "text": "Action Button",
                        "emoji": false
                      },
                      "action_id": "button_action_2"
                    }
                  ]
                },
                {
                  "type": "card",
                  "block_id": "carousel-card-3",
                  "icon": {
                    "type": "image",
                    "image_url": "https://picsum.photos/36/36",
                    "alt_text": "Icon"
                  },
                  "title": {
                    "type": "mrkdwn",
                    "text": "Wellness Center"
                  },
                  "subtitle": {
                    "type": "mrkdwn",
                    "text": "Wellness sessions"
                  },
                  "hero_image": {
                    "type": "image",
                    "image_url": "https://picsum.photos/400/300",
                    "alt_text": "Sample hero image"
                  },
                  "body": {
                    "type": "mrkdwn",
                    "text": "Please take a seat in the waiting room until called."
                  },
                  "actions": [
                    {
                      "type": "button",
                      "text": {
                        "type": "plain_text",
                        "text": "Action Button",
                        "emoji": false
                      },
                      "action_id": "button_action_3"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
