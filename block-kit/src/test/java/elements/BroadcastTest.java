package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class BroadcastTest {
    @Test
    public void testExample01() {
        RichTextBlock block = Broadcast.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "broadcast",
                      "range": "everyone"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
