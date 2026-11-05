package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DatetimePickerTest {
    @Test
    public void testExample01() {
        InputBlock block = DatetimePicker.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "input",
              "element": {
                "type": "datetimepicker",
                "action_id": "datetimepicker-action"
              },
              "hint": {
                "type": "plain_text",
                "text": "This is some hint text",
                "emoji": true
              },
              "label": {
                "type": "plain_text",
                "text": "Start date",
                "emoji": true
              },
              "optional": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
