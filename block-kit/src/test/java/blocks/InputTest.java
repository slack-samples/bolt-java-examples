package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    public void testExample01() {
        InputBlock block = Input.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "input",
              "element": {
                "type": "plain_text_input",
                "multiline": false
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
