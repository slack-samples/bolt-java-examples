package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.slack.api.bolt.util.EventsApiPayloadParser;
import org.junit.jupiter.api.Test;

public class UserConnectionEventTest {
    @Test
    public void testRoutesByTypeOnly() {
        assertEquals("user_connection", EventsApiPayloadParser.getEventTypeAndSubtype(UserConnectionEvent.class));
    }
}
