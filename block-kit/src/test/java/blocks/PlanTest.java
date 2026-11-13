package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.PlanBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class PlanTest {
    @Test
    public void testExample01() {
        PlanBlock block = Plan.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "plan",
              "title": "Thinking completed",
              "tasks": [
                {
                  "type": "task_card",
                  "task_id": "call_001",
                  "title": "Fetched user profile information",
                  "status": "in_progress",
                  "details": {
                    "type": "rich_text",
                    "block_id": "viMWO",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "Searched database..."
                          }
                        ]
                      }
                    ]
                  },
                  "output": {
                    "type": "rich_text",
                    "block_id": "viMWO",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "Profile data loaded"
                          }
                        ]
                      }
                    ]
                  }
                },
                {
                  "type": "task_card",
                  "task_id": "call_002",
                  "title": "Checked user permissions",
                  "status": "in_progress"
                },
                {
                  "type": "task_card",
                  "task_id": "call_003",
                  "title": "Generated comprehensive user report",
                  "status": "complete",
                  "output": {
                    "type": "rich_text",
                    "block_id": "crsk",
                    "elements": [
                      {
                        "type": "rich_text_section",
                        "elements": [
                          {
                            "type": "text",
                            "text": "15 data points compiled"
                          }
                        ]
                      }
                    ]
                  }
                }
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
