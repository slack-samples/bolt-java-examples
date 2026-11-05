package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class TextTest {
    @Test
    public void testExample01() {
        RichTextBlock block = Text.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "text",
                      "text": "Hello there, "
                    },
                    {
                      "type": "text",
                      "text": "I am a bold rich text block!",
                      "style": {
                        "bold": true,
                        "italic": false,
                        "strike": false,
                        "highlight": false,
                        "client_highlight": false,
                        "underline": false,
                        "unlink": false,
                        "code": false
                      }
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
