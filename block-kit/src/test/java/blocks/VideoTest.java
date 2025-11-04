package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.VideoBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class VideoTest {
    @Test
    public void testExample01() {
        VideoBlock block = Video.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected =
                """
            {
              "type": "video",
              "title": {
                "type": "plain_text",
                "text": "Use the Events API to create a dynamic App Home",
                "emoji": true
              },
              "title_url": "https://www.youtube.com/watch?v=8876OZV_Yy0",
              "description": {
                "type": "plain_text",
                "text": "Slack sure is nifty!",
                "emoji": true
              },
              "video_url": "https://www.youtube.com/embed/8876OZV_Yy0?feature=oembed&autoplay=1",
              "alt_text": "Use the Events API to create a dynamic App Home",
              "thumbnail_url": "https://i.ytimg.com/vi/8876OZV_Yy0/hqdefault.jpg"
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
