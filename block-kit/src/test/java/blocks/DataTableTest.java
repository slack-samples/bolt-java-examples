package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.DataTableBlock;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class DataTableTest {
    @Test
    public void testExample01() {
        DataTableBlock block = DataTable.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "data_table",
              "caption": "A list of fruit and their quantities",
              "rows": [
                [
                  {
                    "type": "raw_text",
                    "text": "Fruit"
                  },
                  {
                    "type": "raw_text",
                    "text": "Quantity"
                  }
                ],
                [
                  {
                    "type": "raw_text",
                    "text": "Apples"
                  },
                  {
                    "type": "raw_number",
                    "value": 12.0,
                    "text": "12"
                  }
                ]
              ]
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
