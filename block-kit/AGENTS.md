# Adding an Example

A block kit example is **code-complete** when all four of these are present:

1. Example file
2. Test file
3. README entry
4. Correct docstring

The steps below apply to blocks, elements, and composition objects. Paths and packages differ by category:

| Category | Package | Source path | Test path | Docs path | README section |
|---|---|---|---|---|---|
| Block | `blocks` | `src/main/java/blocks/` | `src/test/java/blocks/` | `blocks/{type}-block` | `### Blocks` |
| Element | `elements` | `src/main/java/elements/` | `src/test/java/elements/` | `block-elements/{type}-element` | `### Block elements` |
| Composition | `compositions` | `src/main/java/compositions/` | `src/test/java/compositions/` | `composition-objects/{type}-object` | `### Composition objects` |

## Example file

Create `src/main/java/{package}/{Type}.java`:

```java
package {package};

import com.slack.api.model.block.{Type}Block;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;

/**
 * {description from docs page — must match exactly}.
 * {@link https://docs.slack.dev/reference/block-kit/{docs-path}/}
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
- Package matches the category (`blocks`, `elements`, or `compositions`)
- Each example is a `public static` method returning the appropriate type
- Methods named `example01()`, `example02()`, etc.
- Use the `Blocks.*` builder DSL (not raw constructors)
- Use `BlockCompositions.markdownText()` / `BlockCompositions.plainText()` for text objects
- Use `BlockElements.*` for interactive elements
- The class-level Javadoc first line must match the docs page `description` field exactly (found in the page's YAML frontmatter)

## Test file

Create `src/test/java/{package}/{Type}Test.java`:

```java
package {package};

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

Add an entry to `block-kit/README.md` in alphabetical order under the matching section:

```markdown
- **[{Name}](https://docs.slack.dev/reference/block-kit/{docs-path})**: {Description matching docs}. [Implementation](./src/main/java/{package}/{Type}.java).
```

The description must match the docs page `description` field exactly.

## Build and verify

```bash
cd block-kit
mvn compile   # compiles + runs Spotless formatter
mvn test      # runs all tests including yours
```

Both must pass. Spotless (Palantir Java Format) runs automatically on compile — do not fight the formatter.
