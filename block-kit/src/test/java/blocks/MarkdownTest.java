package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.MarkdownBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class MarkdownTest {
    @Test
    public void testExample01() {
        MarkdownBlock block = Markdown.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
              {
                "type": "markdown",
                "text": "**Lots of information here!!**"
              }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
