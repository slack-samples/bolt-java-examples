package acme;

import static acme.Acme.PROVIDER_VALUE;
import static acme.Acme.homeView;
import static acme.Acme.provider;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.bolt.App;
import com.slack.api.bolt.context.builtin.ActionContext;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.bolt.request.builtin.BlockActionRequest;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest.PrimaryProvider;
import com.slack.api.model.event.AppHomeOpenedEvent;
import com.slack.api.model.event.UserConnectionEvent;
import com.slack.api.model.event.UserConnectionStatusRequestedEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.event(AppHomeOpenedEvent.class, Main::appHomeOpenedCallback);
        app.blockAction("auth_provider_connect", Main::connectCallback);
        app.blockAction("auth_provider_disconnect", Main::disconnectCallback);
        app.event(UserConnectionEvent.class, Main::userConnectionCallback);
        app.event(UserConnectionStatusRequestedEvent.class, Main::userConnectionStatusRequestedCallback);
        new SocketModeApp(app).start();
    }

    public static Response appHomeOpenedCallback(EventsApiPayload<AppHomeOpenedEvent> payload, EventContext ctx)
            throws IOException, SlackApiException {
        String userId = payload.getEvent().getUser();
        ctx.client().viewsPublish(request -> request.userId(userId).view(homeView(provider(userId))));
        return ctx.ack();
    }

    public static Response connectCallback(BlockActionRequest req, ActionContext ctx)
            throws IOException, SlackApiException {
        BlockActionPayload body = req.getPayload();
        if (!PROVIDER_VALUE.equals(body.getActions().get(0).getValue())) {
            return ctx.ack();
        }
        String userId = body.getUser().getId();
        Connections.connect(userId);
        PrimaryProvider acme = provider(userId);
        ctx.client()
                .appsUserConnectionRequestAuth(request -> request.userId(userId).primaryProvider(acme));
        ctx.client().viewsPublish(request -> request.userId(userId).view(homeView(acme)));
        return ctx.ack();
    }

    public static Response disconnectCallback(BlockActionRequest req, ActionContext ctx)
            throws IOException, SlackApiException {
        BlockActionPayload body = req.getPayload();
        if (!PROVIDER_VALUE.equals(body.getActions().get(0).getValue())) {
            return ctx.ack();
        }
        String userId = body.getUser().getId();
        Connections.disconnect(userId);
        PrimaryProvider acme = provider(userId);
        ctx.client()
                .appsUserConnectionRequestAuth(request -> request.userId(userId).primaryProvider(acme));
        ctx.client().viewsPublish(request -> request.userId(userId).view(homeView(acme)));
        return ctx.ack();
    }

    public static Response userConnectionCallback(EventsApiPayload<UserConnectionEvent> payload, EventContext ctx)
            throws IOException, SlackApiException {
        UserConnectionEvent event = payload.getEvent();
        if ("connect".equals(event.getSubtype())) {
            ctx.client()
                    .appsUserConnectionRequestAuth(request ->
                            request.triggerId(event.getTriggerId()).primaryProvider(provider(event.getUser())));
        }
        return ctx.ack();
    }

    public static Response userConnectionStatusRequestedCallback(
            EventsApiPayload<UserConnectionStatusRequestedEvent> payload, EventContext ctx)
            throws IOException, SlackApiException {
        String userId = payload.getEvent().getUser();
        String status = Connections.isConnected(userId) ? "connected" : "disconnected";
        ctx.client().appsUserConnectionUpdate(request -> request.userId(userId).status(status));
        return ctx.ack();
    }
}
