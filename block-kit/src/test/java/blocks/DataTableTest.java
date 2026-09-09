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
              "rows": [
                [
                  { "type": "raw_text", "text": "Item" },
                  { "type": "raw_text", "text": "Count" }
                ],
                [
                  { "type": "raw_text", "text": "Widgets" },
                  { "type": "raw_number", "value": 42.0, "text": "42" }
                ],
                [
                  { "type": "raw_text", "text": "Gadgets" },
                  { "type": "raw_number", "value": 7.0, "text": "7" }
                ]
              ],
              "caption": "Quarterly widget report",
              "page_size": 10,
              "row_header_column_index": 0
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
