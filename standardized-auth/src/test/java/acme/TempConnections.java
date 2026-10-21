package acme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TempConnections {
    private final Path original = Connections.filename;
    private final Path dir;

    public TempConnections() throws IOException {
        dir = Files.createTempDirectory("acme-");
        Connections.filename = dir.resolve("acme.properties");
    }

    public void close() throws IOException {
        Files.deleteIfExists(Connections.filename);
        Files.delete(dir);
        Connections.filename = original;
    }
}
