package acme;

import com.slack.api.Slack;
import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.bolt.service.InstallationService;
import com.slack.api.bolt.service.builtin.FileInstallationService;
import com.slack.api.bolt.service.builtin.FileOAuthStateService;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        String baseUrl =
                Objects.requireNonNull(System.getenv("BASE_URL"), "Set BASE_URL to the public URL of this app");
        InstallationService installations = new FileInstallationService(AcmeApp.config(), "./data/installations");
        AcmeListeners listeners = new AcmeListeners(
                Slack.getInstance(), new AcmeAccounts(installations), new AcmeProvider(baseUrl + "/slack/install"));

        App api = AcmeApp.api(AcmeApp.config(), installations, listeners);
        App oauth = AcmeApp.oauth(
                AcmeApp.config(),
                installations,
                new FileOAuthStateService(AcmeApp.config(), "./data/states"),
                listeners);

        int port = Integer.parseInt(Optional.ofNullable(System.getenv("PORT")).orElse("3000"));
        new SlackAppServer(new HashMap<>(Map.of("/slack/events", api, "/slack/", oauth)), port).start();
    }
}
