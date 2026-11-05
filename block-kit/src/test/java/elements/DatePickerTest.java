package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DatePickerTest {
    @Test
    public void testExample01() {
        SectionBlock block = DatePicker.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "section",
              "block_id": "section1234",
              "text": {
                "type": "mrkdwn",
                "text": "Pick a date for the deadline."
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
