package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.HeaderBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class HeaderTest {
    @Test
    public void testExample01() {
        HeaderBlock block = Header.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "header",
              "text": {
                "type": "plain_text",
                "text": "A Heartfelt Header"
              }
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
