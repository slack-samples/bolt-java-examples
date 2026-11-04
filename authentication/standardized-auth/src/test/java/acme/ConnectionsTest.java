package acme;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectionsTest {
    private TempConnections connections;

    @BeforeEach
    public void setUp() throws Exception {
        connections = new TempConnections();
    }

    @AfterEach
    public void tearDown() throws Exception {
        connections.close();
    }

    @Test
    public void testRemembersAConnectedUser() {
        Connections.connect("U0ADA");

        assertTrue(Connections.isConnected("U0ADA"));
    }

    @Test
    public void testDisconnectForgetsTheUser() {
        Connections.connect("U0ADA");

        Connections.disconnect("U0ADA");

        assertFalse(Connections.isConnected("U0ADA"));
    }

    @Test
    public void testDisconnectKeepsOtherUsersConnected() {
        Connections.connect("U0ADA");
        Connections.connect("U0BOB");

        Connections.disconnect("U0ADA");

        assertTrue(Connections.isConnected("U0BOB"));
    }

    @Test
    public void testDisconnectingAnUnknownUserChangesNothing() {
        Connections.disconnect("U0ADA");

        assertFalse(Connections.isConnected("U0ADA"));
    }
}
