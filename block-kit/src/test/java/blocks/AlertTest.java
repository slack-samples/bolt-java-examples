package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.AlertBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class AlertTest {
    @Test
    public void testExample01() {
        AlertBlock block = Alert.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "alert",
              "text": {
                "type": "mrkdwn",
                "text": "The work is mysterious and important."
              },
              "level": "info"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
