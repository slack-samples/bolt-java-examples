package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class EmojiTest {
    @Test
    public void testExample01() {
        RichTextBlock block = Emoji.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "emoji",
                      "name": "basketball"
                    },
                    {
                      "type": "text",
                      "text": " "
                    },
                    {
                      "type": "emoji",
                      "name": "snowboarder"
                    },
                    {
                      "type": "text",
                      "text": " "
                    },
                    {
                      "type": "emoji",
                      "name": "checkered_flag"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
