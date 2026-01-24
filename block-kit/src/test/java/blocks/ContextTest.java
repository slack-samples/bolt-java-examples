package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ContextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ContextTest {
    @Test
    public void testExample01() {
        ContextBlock block = Context.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "context",
              "elements": [
                {
                  "type": "image",
                  "image_url": "https://image.freepik.com/free-photo/red-drawing-pin_1156-445.jpg",
                  "alt_text": "images"
                },
                {
                  "type": "mrkdwn",
                  "text": "Location: **Dogpatch**"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
