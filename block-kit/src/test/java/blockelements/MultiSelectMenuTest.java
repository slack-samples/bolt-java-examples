package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class MultiSelectMenuTest {
    @Test
    public void testExample01() {
        SectionBlock block = MultiSelectMenu.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick items from the list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "multi_static_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select items"
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
        SectionBlock block = MultiSelectMenu.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick items from the list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "multi_external_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select items"
                },
                "min_query_length": 3
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        SectionBlock block = MultiSelectMenu.example03();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick users from the list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "multi_users_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select users"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample04() {
        SectionBlock block = MultiSelectMenu.example04();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick conversations from the list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "multi_conversations_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select conversations"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample05() {
        SectionBlock block = MultiSelectMenu.example05();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section678",
              "text": {
                "type": "mrkdwn",
                "text": "Pick channels from the list"
              },
              "accessory": {
                "action_id": "text1234",
                "type": "multi_channels_select",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select channels"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
