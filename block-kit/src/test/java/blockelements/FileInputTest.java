package blockelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.InputBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class FileInputTest {
    @Test
    public void testExample01() {
        InputBlock block = FileInput.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
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
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
