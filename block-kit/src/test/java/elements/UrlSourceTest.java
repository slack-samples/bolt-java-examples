package elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.TaskCardBlock;
import com.slack.api.model.block.element.UrlSourceElement;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class UrlSourceTest {
    @Test
    public void testExample01() {
        UrlSourceElement element = UrlSource.example01();
        String actual = GsonFactory.createSnakeCase().toJson(element);
        String expected = """
            {
              "type": "url",
              "url": "https://docs.slack.dev/",
              "text": "Slack API docs"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }

    @Test
    public void testExample02() {
        TaskCardBlock block = UrlSource.example02();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "task_card",
              "task_id": "task_1",
              "title": "Scientific findings",
              "status": "complete",
              "sources": [
                {
                  "type": "url",
                  "url": "https://docs.example.com/",
                  "text": "Tracy's delightful docs"
                },
                {
                  "type": "url",
                  "url": "https://research.example.com/",
                  "text": "Haley's resourceful research"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
