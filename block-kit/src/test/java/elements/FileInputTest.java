package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.view.View;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class FileInputTest {
    @Test
    public void testExample01() {
        View view = FileInput.example01();
        String actual = GsonFactory.createSnakeCase().toJson(view);
        String expected = """
            {
              "type": "modal",
              "title": {
                "type": "plain_text",
                "text": "My App",
                "emoji": true
              },
              "submit": {
                "type": "plain_text",
                "text": "Submit",
                "emoji": true
              },
              "close": {
                "type": "plain_text",
                "text": "Cancel",
                "emoji": true
              },
              "blocks": [
                {
                  "type": "input",
                  "block_id": "input_block_id",
                  "label": {
                    "type": "plain_text",
                    "text": "Upload Files"
                  },
                  "element": {
                    "type": "file_input",
                    "action_id": "file_input_action_id_1",
                    "filetypes": ["jpg", "png"],
                    "max_files": 5
                  },
                  "optional": false
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
