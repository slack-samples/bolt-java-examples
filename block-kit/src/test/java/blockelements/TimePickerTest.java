package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class TimePickerTest {
    @Test
    public void testExample01() {
        SectionBlock block = TimePicker.example01();
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
                "type": "timepicker",
                "timezone": "America/Los_Angeles",
                "action_id": "timepicker123",
                "initial_time": "11:40",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Select a time"
                }
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
