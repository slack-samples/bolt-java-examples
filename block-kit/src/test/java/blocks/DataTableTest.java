package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DataTableTest {
    @Test
    public void testExample01() {
        DataTableBlock block = DataTable.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "data_table",
              "caption": "A Fabulous Table",
              "rows": [
                [
                  {
                    "type": "raw_text",
                    "text": "Name"
                  },
                  {
                    "type": "raw_text",
                    "text": "Department"
                  },
                  {
                    "type": "raw_text",
                    "text": "Badge"
                  }
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Data Refinement Department"
                  },
                  {
                    "type": "raw_text",
                    "text": "MDR"
                  },
                  {
                    "type": "rich_text",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "Blue",
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
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Art Sourcing Department"
                  },
                  {
                    "type": "raw_text",
                    "text": "O&D"
                  },
                  {
                    "type": "rich_text",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "Green"
                          },
                          {
                            "type": "text",
                            "text": "review",
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
                  }
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Wellness Department"
                  },
                  {
                    "type": "raw_text",
                    "text": "Wellness Center"
                  },
                  {
                    "type": "rich_text",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "Limited",
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
                ]
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
