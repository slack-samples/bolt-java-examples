package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.ContextActionsBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class IconButtonTest {
    @Test
    public void testExample01() {
        ContextActionsBlock block = IconButton.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "context_actions",
              "elements": [
                {
                  "type": "icon_button",
                  "icon": "trash",
                  "text": {
                    "type": "plain_text",
                    "text": "Delete"
                  },
                  "action_id": "delete_button",
                  "value": "delete_item"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
