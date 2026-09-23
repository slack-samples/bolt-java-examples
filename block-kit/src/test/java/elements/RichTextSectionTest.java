package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RichTextSectionTest {
    @Test
    public void testExample01() {
        List<RichTextBlock> blocks = RichTextSection.example01();
        String actual = GsonFactory.createSnakeCase().toJson(blocks);
        String expected = """
            [
              {
                "type": "rich_text",
                "elements": [
                  {
                    "type": "rich_text_section",
                    "elements": [
                      {
                        "type": "text",
                        "text": "Hello there, I am a basic rich text block!"
                      }
                    ]
                  }
                ]
              },
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
              },
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
                        "text": "I am an italic rich text block!",
                        "style": {
                          "bold": false,
                          "italic": true,
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
              },
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
                        "text": "I am a strikethrough rich text block!",
                        "style": {
                          "bold": false,
                          "italic": false,
                          "strike": true,
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
            ]
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
