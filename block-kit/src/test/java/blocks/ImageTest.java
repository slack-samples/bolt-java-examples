package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ImageBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ImageTest {
    @Test
    public void testExample01() {
        ImageBlock block = Image.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "image",
              "title": {
                "type": "plain_text",
                "text": "Please enjoy this photo of a kitten"
              },
              "block_id": "image4",
              "image_url": "http://placekitten.com/500/500",
              "alt_text": "An incredibly cute kitten."
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        ImageBlock block = Image.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "image",
              "title": {
                "type": "plain_text",
                "text": "Please enjoy this photo of a kitten"
              },
              "block_id": "image4",
              "slack_file": {
                "url": "https://files.slack.com/files-pri/T0123456-F0123456/xyz.png"
              },
              "alt_text": "An incredibly cute kitten."
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        ImageBlock block = Image.example03();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "image",
              "title": {
                "type": "plain_text",
                "text": "Please enjoy this photo of a kitten"
              },
              "block_id": "image4",
              "slack_file": {
                "id": "F0123456"
              },
              "alt_text": "An incredibly cute kitten."
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
