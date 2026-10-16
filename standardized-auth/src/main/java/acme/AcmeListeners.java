package acme;

import acme.AcmeProvider.Connection;
import com.slack.api.Slack;
import com.slack.api.bolt.context.Context;
import com.slack.api.bolt.model.Installer;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.service.builtin.oauth.OAuthV2SuccessPersistenceCallback;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.SlackApiTextResponse;
import com.slack.api.methods.response.auth.AuthTestResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public final class AcmeListeners {
    private final Slack slack;
    private final AcmeAccounts accounts;
    private final AcmeProvider provider;

    public AcmeListeners(Slack slack, AcmeAccounts accounts, AcmeProvider provider) {
        this.slack = slack;
        this.accounts = accounts;
        this.provider = provider;
    }

    public void reportConnected(OAuthV2SuccessPersistenceCallback.Arguments args) {
        Installer installer = args.getInstaller();
        MethodsClient client = slack.methods(installer.getBotAccessToken(), installer.getTeamId());
        try {
            report(client, installer.getInstallerUserId(), connectionOf(client, Optional.of(installer)));
        } catch (IOException | SlackApiException error) {
            throw new IllegalStateException("Failed to report the Acme connection", error);
        }
        showSuccessPage(args);
    }

    public void publishHome(MethodsClient client, Context context, String userId)
            throws IOException, SlackApiException {
        Optional<Connection> connection = connectionOf(client, accounts.find(context, userId));
        requireOk(client.viewsPublish(request -> request.userId(userId).view(provider.homeView(connection))));
    }

    public void answerStatusRequest(MethodsClient client, Context context, String userId)
            throws IOException, SlackApiException {
        String status = accounts.find(context, userId).isPresent() ? "connected" : "disconnected";
        requireOk(client.appsUserConnectionUpdate(
                request -> request.userId(userId).status(status)));
    }

    public void forgetRevokedUsers(MethodsClient client, Context context, List<String> userIds)
            throws IOException, SlackApiException {
        for (String userId : Optional.ofNullable(userIds).orElse(List.of())) {
            accounts.forget(context, userId);
            report(client, userId, Optional.empty());
        }
    }

    public void handleUserConnection(
            MethodsClient client, Context context, String subtype, String userId, String triggerId)
            throws IOException, SlackApiException {
        if (subtype.equals("connect")) {
            openConnectModal(client, context, userId, triggerId);
        } else if (subtype.equals("disconnect")) {
            disconnect(client, context, userId);
        }
    }

    public void disconnect(MethodsClient client, Context context, String userId) throws IOException, SlackApiException {
        Optional<String> forgottenToken = accounts.forget(context, userId);
        report(client, userId, Optional.empty());
        if (forgottenToken.isPresent()) {
            requireOk(client.authRevoke(request -> request.token(forgottenToken.get())));
        }
    }

    private void openConnectModal(MethodsClient client, Context context, String userId, String triggerId)
            throws IOException, SlackApiException {
        Optional<Connection> connection = connectionOf(client, accounts.find(context, userId));
        requireOk(client.appsUserConnectionRequestAuth(
                request -> request.triggerId(triggerId).primaryProvider(provider.primaryProvider(connection))));
    }

    private void report(MethodsClient client, String userId, Optional<Connection> connection)
            throws IOException, SlackApiException {
        requireOk(client.appsUserConnectionRequestAuth(
                request -> request.userId(userId).primaryProvider(provider.primaryProvider(connection))));
        requireOk(client.viewsPublish(request -> request.userId(userId).view(provider.homeView(connection))));
    }

    private static Optional<Connection> connectionOf(MethodsClient client, Optional<Installer> account)
            throws IOException, SlackApiException {
        if (account.isEmpty()) {
            return Optional.empty();
        }
        AuthTestResponse identity =
                requireOk(client.authTest(request -> request.token(account.get().getInstallerUserAccessToken())));
        return Optional.of(new Connection("@" + identity.getUser(), identity.getTeam()));
    }

    private static void showSuccessPage(OAuthV2SuccessPersistenceCallback.Arguments args) {
        Response response = args.getResponse();
        response.setStatusCode(200);
        response.setContentType("text/html; charset=utf-8");
        response.setBody(args.getPageRenderer()
                .renderSuccessPage(args.getInstaller(), args.getAppConfig().getOauthCompletionUrl()));
    }

    private static <T extends SlackApiTextResponse> T requireOk(T response) {
        if (!response.isOk()) {
            throw new IllegalStateException(response.getError());
        }
        return response;
    }
}
