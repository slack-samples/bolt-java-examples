package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class EmailInputTest {
    @Test
    public void testExample01() {
        InputBlock block = EmailInput.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "input",
              "block_id": "input123",
              "label": {
                "type": "plain_text",
                "text": "Email Address"
              },
              "element": {
                "type": "email_text_input",
                "action_id": "email_text_input-action",
                "placeholder": {
                  "type": "plain_text",
                  "text": "Enter an email"
                }
              },
              "optional": false
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
