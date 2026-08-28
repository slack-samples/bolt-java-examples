package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ImageTest {
    @Test
    public void testExample01() {
        SectionBlock block = Image.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section567",
              "text": {
                "type": "mrkdwn",
                "text": "This is a section block with an accessory image."
              },
              "accessory": {
                "type": "image",
                "image_url": "https://pbs.twimg.com/profile_images/625633822235693056/lNGUneLX_400x400.jpg",
                "alt_text": "cute cat"
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        SectionBlock block = Image.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section567",
              "text": {
                "type": "mrkdwn",
                "text": "This is a section block with an accessory image."
              },
              "accessory": {
                "type": "image",
                "slack_file": {
                  "url": "https://files.slack.com/files-pri/T0123456-F0123456/xyz.png"
                },
                "alt_text": "Slack file object."
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        SectionBlock block = Image.example03();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section567",
              "text": {
                "type": "mrkdwn",
                "text": "This is a section block with an accessory image."
              },
              "accessory": {
                "type": "image",
                "slack_file": {
                  "id": "F01234567"
                },
                "alt_text": "Slack file object."
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
