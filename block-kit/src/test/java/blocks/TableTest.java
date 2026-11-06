package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.TableBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class TableTest {
    @Test
    public void testExample01() {
        TableBlock block = Table.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "table",
              "column_settings": [
                {
                  "is_wrapped": true
                },
                {
                  "align": "right"
                }
              ],
              "rows": [
                [
                  {
                    "type": "raw_text",
                    "text": "Header A"
                  },
                  {
                    "type": "raw_text",
                    "text": "Header B"
                  }
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Data 1A"
                  },
                  {
                    "type": "rich_text",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "text": "Data 1B",
                            "type": "link",
                            "url": "https://slack.com"
                          }
                        ]
                      }
                    ]
                  }
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Data 2A"
                  },
                  {
                    "type": "rich_text",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "text": "Data 2B",
                            "type": "link",
                            "url": "https://slack.com"
                          }
                        ]
                      }
                    ]
                  }
                ]
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
