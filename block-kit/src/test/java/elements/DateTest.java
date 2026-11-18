package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DateTest {
    @Test
    public void testExample01() {
        RichTextBlock block = Date.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "date",
                      "timestamp": 1720710212,
                      "format": "{date_num} at {time}",
                      "fallback": "timey"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
