package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RichTextListTest {
    @Test
    public void testExample01() {
        RichTextBlock block = RichTextList.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "block_id": "block1",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "text",
                      "text": "My favorite Slack features (in no particular order):"
                    }
                  ]
                },
                {
                  "type": "rich_text_list",
                  "style": "bullet",
                  "indent": 0,
                  "border": 1,
                  "elements": [
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Huddles"
                        }
                      ]
                    },
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Canvas"
                        }
                      ]
                    },
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Developing with Block Kit"
                        }
                      ]
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        RichTextBlock block = RichTextList.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "block_id": "block1",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "text",
                      "text": "Breakfast foods I enjoy:"
                    }
                  ]
                },
                {
                  "type": "rich_text_list",
                  "style": "bullet",
                  "elements": [
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Hashbrowns"
                        }
                      ]
                    },
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Eggs"
                        }
                      ]
                    }
                  ]
                },
                {
                  "type": "rich_text_list",
                  "style": "bullet",
                  "indent": 1,
                  "elements": [
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Scrambled"
                        }
                      ]
                    },
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Over easy"
                        }
                      ]
                    }
                  ]
                },
                {
                  "type": "rich_text_list",
                  "style": "bullet",
                  "elements": [
                    {
                      "type": "rich_text_section",
                      "elements": [
                        {
                          "type": "text",
                          "text": "Pancakes, extra syrup"
                        }
                      ]
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
