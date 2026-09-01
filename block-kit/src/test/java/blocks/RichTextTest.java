package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RichTextTest {
    @Test
    public void testExample01() {
        java.util.List<RichTextBlock> blocks = RichText.example01();
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

    @Test
    public void testExample02() {
        RichTextBlock block = RichText.example02();
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
                  ],
                  "style": "bullet",
                  "indent": 0,
                  "border": 1
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        RichTextBlock block = RichText.example03();
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

    @Test
    public void testExample04() {
        RichTextBlock block = RichText.example04();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_preformatted",
                  "elements": [
                    {
                      "type": "text",
                      "text": "{\\n  \\"object\\": {\\n    \\"description\\": \\"this is an example of a json object\\"\\n  }\\n}"
                    }
                  ],
                  "border": 0
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample05() {
        RichTextBlock block = RichText.example05();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "block_id": "Vrzsu",
              "elements": [
                {
                  "type": "rich_text_quote",
                  "elements": [
                    {
                      "type": "text",
                      "text": "What we need is good examples in our documentation."
                    }
                  ]
                },
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "text",
                      "text": "Yes - I completely agree, Luke!"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample06() {
        RichTextBlock block = RichText.example06();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "broadcast",
                      "range": "everyone"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample07() {
        RichTextBlock block = RichText.example07();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "color",
                      "value": "#F405B3"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample08() {
        RichTextBlock block = RichText.example08();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "channel",
                      "channel_id": "C123ABC456"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample09() {
        RichTextBlock block = RichText.example09();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "date",
                      "timestamp": 1720710212,
                      "format": "{date_num} at {time}",
                      "fallback": "timey"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample10() {
        RichTextBlock block = RichText.example10();
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

    @Test
    public void testExample11() {
        RichTextBlock block = RichText.example11();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "link",
                      "url": "https://api.slack.com"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample12() {
        RichTextBlock block = RichText.example12();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "user",
                      "user_id": "U123ABC456"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample13() {
        RichTextBlock block = RichText.example13();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "usergroup",
                      "usergroup_id": "G123ABC456"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
