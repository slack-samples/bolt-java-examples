package acme;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class Connections {
    static Path filename = Path.of("acme.properties");

    private Connections() {}

    public static void connect(String userId) {
        Properties db = read();
        db.setProperty(userId, "true");
        write(db);
    }

    public static void disconnect(String userId) {
        Properties db = read();
        db.remove(userId);
        write(db);
    }

    public static boolean isConnected(String userId) {
        return read().containsKey(userId);
    }

    private static Properties read() {
        Properties db = new Properties();
        if (Files.notExists(filename)) {
            return db;
        }
        try (Reader reader = Files.newBufferedReader(filename)) {
            db.load(reader);
        } catch (IOException error) {
            throw new UncheckedIOException(error);
        }
        return db;
    }

    private static void write(Properties db) {
        try (Writer writer = Files.newBufferedWriter(filename)) {
            db.store(writer, null);
        } catch (IOException error) {
            throw new UncheckedIOException(error);
        }
    }
}
