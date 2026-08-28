# Adding a Block Example

A block example is **code-complete** when all four of these are present:

1. Example file
2. Test file
3. README entry
4. Correct docstring

## Example file

Create `src/main/java/blocks/{Type}.java`:

```java
package blocks;

import com.slack.api.model.block.{Type}Block;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;

/**
 * {description from docs page — must match exactly}.
 * {@link https://docs.slack.dev/reference/block-kit/blocks/{type}-block/}
 */
public class {Type} {
    /**
     * {Brief description of this specific example}.
     */
    public static {Type}Block example01() {
        {Type}Block block = Blocks.{type}(b -> b. /* builder calls */ );
        return block;
    }
}
```

Rules:
- Package is always `blocks`
- Each example is a `public static` method returning the block type
- Methods named `example01()`, `example02()`, etc.
- Use the `Blocks.*` builder DSL (not raw constructors)
- Use `BlockCompositions.markdownText()` / `BlockCompositions.plainText()` for text objects
- Use `BlockElements.*` for interactive elements
- The class-level Javadoc first line must match the docs page `description` field exactly (found in the page's YAML frontmatter)

## Test file

Create `src/test/java/blocks/{Type}Test.java`:

```java
package blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonParser;
import com.slack.api.model.block.{Type}Block;
import com.slack.api.util.json.GsonFactory;
import org.junit.jupiter.api.Test;

public class {Type}Test {
    @Test
    public void testExample01() {
        {Type}Block block = {Type}.example01();
        String actual = GsonFactory.createSnakeCase().toJson(block);
        String expected = """
            {
              "type": "{type}",
              ...
            }
            """;
        assertEquals(JsonParser.parseString(expected), JsonParser.parseString(actual));
    }
}
```

The expected JSON must match the docs page example exactly (minus the outer `"blocks": [...]` wrapper).

## README entry

Add an entry to `block-kit/README.md` in alphabetical order under `### Blocks`:

```markdown
- **[{Name}](https://docs.slack.dev/reference/block-kit/blocks/{type}-block)**: {Description matching docs}. [Implementation](./src/main/java/blocks/{Type}.java).
```

The description must match the docs page `description` field exactly.

## Build and verify

```bash
cd block-kit
mvn compile   # compiles + runs Spotless formatter
mvn test      # runs all tests including yours
```

Both must pass. Spotless (Palantir Java Format) runs automatically on compile — do not fight the formatter.
