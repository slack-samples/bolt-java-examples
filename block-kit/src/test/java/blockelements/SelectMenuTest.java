package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class SelectMenuTest {
    @Test
    public void testExample01() {
        SectionBlock block = SelectMenu.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick an item from the dropdown list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "static_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select an item"
                },
                "options": [
                  {
                    "text": {
                      "type": "plain_text",
                      "text": "*this is plain_text text*"
                    },
                    "value": "value-0"
                  },
                  {
                    "text": {
                      "type": "plain_text",
                      "text": "*this is plain_text text*"
                    },
                    "value": "value-1"
                  },
                  {
                    "text": {
                      "type": "plain_text",
                      "text": "*this is plain_text text*"
                    },
                    "value": "value-2"
                  }
                ]
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        SectionBlock block = SelectMenu.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick an item from the dropdown list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "external_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select an item"
                },
                "min_query_length": 3
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        SectionBlock block = SelectMenu.example03();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick a user from the dropdown list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "users_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select an item"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample04() {
        SectionBlock block = SelectMenu.example04();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick a conversation from the dropdown list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "conversations_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select an item"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample05() {
        SectionBlock block = SelectMenu.example05();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick a channel from the dropdown list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "channels_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select an item"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
