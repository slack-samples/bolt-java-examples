package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class SectionTest {
    @Test
    public void testExample01() {
        SectionBlock block = Section.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "section",
              "text": {
                "type": "mrkdwn",
                "text": "A message *with some bold text* and _some italicized text_."
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        SectionBlock block = Section.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "section",
              "text": {
                "text": "A message *with some bold text* and _some italicized text_.",
                "type": "mrkdwn"
              },
              "fields": [
                {
                  "type": "mrkdwn",
                  "text": "High"
                },
                {
                  "type": "plain_text",
                  "emoji": true,
                  "text": "Silly"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample03() {
        SectionBlock block = Section.example03();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "section",
              "text": {
                    "text": "*Haley* has requested you set a deadline for finding a house",
                "type": "mrkdwn"
              },
              "accessory": {
                "type": "datepicker",
                "action_id": "datepicker123",
                "initial_date": "1990-04-28",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select a date"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
