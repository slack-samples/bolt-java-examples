package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ActionsBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class ActionsTest {
    @Test
    public void testExample01() {
        ActionsBlock block = Actions.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "actions",
              "block_id": "actions1",
              "elements": [
                {
                  "type": "static_select",
                  "placeholder":{
                      "type": "plain_text",
                      "text": "Which witch is the witchiest witch?"
                  },
                  "action_id": "select_2",
                  "options": [
                    {
                      "text": {
                          "type": "plain_text",
                          "text": "Matilda"
                      },
                      "value": "matilda"
                    },
                    {
                      "text": {
                          "type": "plain_text",
                          "text": "Glinda"
                      },
                      "value": "glinda"
                    },
                    {
                      "text": {
                          "type": "plain_text",
                          "text": "Granny Weatherwax"
                      },
                      "value": "grannyWeatherwax"
                    },
                    {
                      "text": {
                          "type": "plain_text",
                          "text": "Hermione"
                      },
                      "value": "hermione"
                    }
                  ]
                },
                {
                  "type": "button",
                  "text": {
                      "type": "plain_text",
                      "text": "Cancel"
                  },
                  "value": "cancel",
                  "action_id": "button_1"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        ActionsBlock block = Actions.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "actions",
              "block_id": "actionblock789",
              "elements": [
                {
                  "type": "datepicker",
                  "action_id": "datepicker123",
                  "initial_date": "1990-04-28",
                  "placeholder": {
                    "type": "plain_text",
                    "text": "Select a date"
                  }
                },
                {
                  "type": "overflow",
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
                    },
                    {
                      "text": {
                        "type": "plain_text",
                        "text": "*this is plain_text text*"
                      },
                      "value": "value-3"
                    },
                    {
                      "text": {
                        "type": "plain_text",
                        "text": "*this is plain_text text*"
                      },
                      "value": "value-4"
                    }
                  ],
                  "action_id": "overflow"
                },
                {
                  "type": "button",
                  "text": {
                    "type": "plain_text",
                    "text": "Click Me"
                  },
                  "value": "click_me_123",
                  "action_id": "button"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
