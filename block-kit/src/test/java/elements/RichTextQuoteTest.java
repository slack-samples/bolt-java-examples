package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class RichTextQuoteTest {
    @Test
    public void testExample01() {
        RichTextBlock block = RichTextQuote.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "rich_text",
              "block_id": "Vrzsu",
              "elements": [
                {
                  "type": "rich_text_quote",
                  "elements": [
                    {
                      "type": "text",
                      "text": "What we need is good examples in our documentation."
                    }
                  ]
                },
                {
                  "type": "rich_text_section",
                  "elements": [
                    {
                      "type": "text",
                      "text": "Yes - I completely agree, Luke!"
                    }
                  ]
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
