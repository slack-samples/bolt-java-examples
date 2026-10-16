package acme;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.service.InstallationService;
import com.slack.api.bolt.service.OAuthStateService;
import com.slack.api.model.event.AppHomeOpenedEvent;
import com.slack.api.model.event.TokensRevokedEvent;
import com.slack.api.model.event.UserConnectionStatusRequestedEvent;

public final class AcmeApp {
    private AcmeApp() {}

    public static AppConfig config() {
        return AppConfig.builder()
                .singleTeamBotToken(null)
                .scope("users:read")
                .userScope("users.profile:read")
                .oauthInstallPath("install")
                .oauthRedirectUriPath("oauth_redirect")
                .oAuthInstallPathEnabled(true)
                .oAuthRedirectUriPathEnabled(true)
                .oAuthInstallPageRenderingEnabled(false)
                .build();
    }

    public static App api(AppConfig config, InstallationService installations, AcmeListeners listeners) {
        App app = new App(config).service(installations);
        app.event(AppHomeOpenedEvent.class, (payload, ctx) -> {
            listeners.publishHome(ctx.client(), ctx, payload.getEvent().getUser());
            return ctx.ack();
        });
        app.event(UserConnectionStatusRequestedEvent.class, (payload, ctx) -> {
            listeners.answerStatusRequest(ctx.client(), ctx, payload.getEvent().getUser());
            return ctx.ack();
        });
        app.event(TokensRevokedEvent.class, (payload, ctx) -> {
            listeners.forgetRevokedUsers(
                    ctx.client(), ctx, payload.getEvent().getTokens().getOauth());
            return ctx.ack();
        });
        app.blockAction(AcmeProvider.CONNECT_ACTION_ID, (req, ctx) -> ctx.ack());
        app.blockAction(AcmeProvider.DISCONNECT_ACTION_ID, (req, ctx) -> {
            listeners.disconnect(ctx.client(), ctx, req.getPayload().getUser().getId());
            return ctx.ack();
        });
        return app;
    }

    public static App oauth(
            AppConfig config, InstallationService installations, OAuthStateService states, AcmeListeners listeners) {
        return new App(config)
                .asOAuthApp(true)
                .service(installations)
                .service(states)
                .oauthPersistenceCallback(listeners::reportConnected);
    }
}
