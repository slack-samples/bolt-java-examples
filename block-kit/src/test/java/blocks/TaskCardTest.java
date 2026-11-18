package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.TaskCardBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class TaskCardTest {
    @Test
    public void testExample01() {
        TaskCardBlock block = TaskCard.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "task_card",
              "task_id": "task_1",
              "title": "Fetching weather data",
              "status": "in_progress",
              "output": {
                "type": "rich_text",
                "elements": [
                  {
                    "type": "rich_text_section",
                    "elements": [
                      {
                        "type": "text",
                        "text": "Found weather data for Chicago from 2 sources"
                      }
                    ]
                  }
                ]
              },
              "sources": [
                {
                  "type": "url",
                  "url": "https://weather.com/",
                  "text": "weather.com"
                },
                {
                  "type": "url",
                  "url": "https://www.accuweather.com/",
                  "text": "accuweather.com"
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
