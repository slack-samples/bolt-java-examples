package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.FileBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class FileTest {
    @Test
    public void testExample01() {
        FileBlock block = File.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "file",
              "external_id": "ABCD1",
              "source": "remote"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
