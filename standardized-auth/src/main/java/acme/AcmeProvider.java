package acme;

import static com.slack.api.model.block.Blocks.authProvider;
import static com.slack.api.model.block.Blocks.section;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;

import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest.PrimaryProvider;
import com.slack.api.model.block.AuthProviderBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.composition.PlainTextObject;
import com.slack.api.model.view.View;
import java.util.List;
import java.util.Optional;

public final class AcmeProvider {
    public static final String VALUE = "acme";
    public static final String CONNECT_ACTION_ID = "auth_provider_connect_" + VALUE;
    public static final String DISCONNECT_ACTION_ID = "auth_provider_disconnect_" + VALUE;

    public static final String WELCOME_GREETING = """
            *Welcome to Acme!* :rocket:
            Connect your Acme account to start ordering. Anvils ship same day, gravity permitting.""";
    public static final String CONNECTED_GREETING = """
            *You're all set!* :tada:
            Your Acme account is connected. Please keep giant magnets away from your laptop.""";

    public record Connection(String identity, String context) {}

    private final String authUrl;

    public AcmeProvider(String authUrl) {
        this.authUrl = authUrl;
    }

    public PrimaryProvider primaryProvider(Optional<Connection> connection) {
        return PrimaryProvider.builder()
                .value(VALUE)
                .name(name())
                .description(description())
                .authUrl(authUrl)
                .isConnected(connection.isPresent())
                .connectedIdentity(connection
                        .map(Connection::identity)
                        .map(BlockCompositions::plainText)
                        .orElse(null))
                .connectedContext(connection
                        .map(Connection::context)
                        .map(BlockCompositions::plainText)
                        .orElse(null))
                .build();
    }

    public AuthProviderBlock block(Optional<Connection> connection) {
        return authProvider(block -> block.value(VALUE)
                .name(name())
                .description(description())
                .authUrl(authUrl)
                .isConnected(connection.isPresent())
                .connectedIdentity(connection
                        .map(Connection::identity)
                        .map(BlockCompositions::plainText)
                        .orElse(null))
                .connectedContext(connection
                        .map(Connection::context)
                        .map(BlockCompositions::plainText)
                        .orElse(null)));
    }

    public View homeView(Optional<Connection> connection) {
        String greeting = connection.isPresent() ? CONNECTED_GREETING : WELCOME_GREETING;
        return View.builder()
                .type("home")
                .blocks(List.of(section(section -> section.text(markdownText(greeting))), block(connection)))
                .build();
    }

    private static PlainTextObject name() {
        return BlockCompositions.plainText("Acme account");
    }

    private static PlainTextObject description() {
        return BlockCompositions.plainText("Order rocket skates, anvils, and giant magnets without leaving Slack.");
    }
}
