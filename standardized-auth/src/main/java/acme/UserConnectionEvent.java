package acme;

import com.slack.api.model.event.Event;

public class UserConnectionEvent implements Event {
    public static final String TYPE_NAME = "user_connection";

    private final String type = TYPE_NAME;
    private String subtype;
    private String user;
    private String triggerId;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSubtype() {
        return subtype;
    }

    public String getUser() {
        return user;
    }

    public String getTriggerId() {
        return triggerId;
    }
}
