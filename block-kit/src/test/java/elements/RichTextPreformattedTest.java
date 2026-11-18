package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RichTextPreformattedTest {
    @Test
    public void testExample01() {
        RichTextBlock block = RichTextPreformatted.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "elements": [
                {
                  "type": "rich_text_preformatted",
                  "border": 0,
                  "elements": [
                    {
                      "type": "text",
                      "text": "{\\n  \\"object\\": {\\n    \\"description\\": \\"this is an example of a json object\\"\\n  }\\n}"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
