package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class NumberInputTest {
    @Test
    public void testExample01() {
        InputBlock block = NumberInput.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "input",
              "element": {
                "type": "number_input",
                "is_decimal_allowed": false,
                "action_id": "number_input-action"
              },
              "label": {
                "type": "plain_text",
                "text": "Label",
                "emoji": true
              },
              "optional": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
