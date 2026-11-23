package acme;

import static com.slack.api.model.block.Blocks.asBlocks;
import static com.slack.api.model.block.Blocks.authProvider;
import static com.slack.api.model.block.Blocks.section;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;
import static com.slack.api.model.view.Views.view;

import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest.PrimaryProvider;
import com.slack.api.model.view.View;

public final class Acme {
    public static final String PROVIDER_VALUE = "acme";

    private Acme() {}

    public static PrimaryProvider provider(String userId) {
        PrimaryProvider acme = PrimaryProvider.builder()
                .value(PROVIDER_VALUE)
                .name(plainText("Acme account"))
                .description(plainText("Order rocket skates, anvils, and giant magnets without leaving Slack."))
                .isConnected(Connections.isConnected(userId))
                .build();
        if (acme.getIsConnected()) {
            acme.setConnectedIdentity(plainText(userId));
        }
        return acme;
    }

    public static View homeView(PrimaryProvider acme) {
        return view(view -> view.type("home")
                .blocks(asBlocks(
                        section(section -> section.text(markdownText("*Welcome to Acme!* :rocket:\n"
                                + "Anvils ship same day, gravity permitting. "
                                + "Please keep giant magnets away from your laptop."))),
                        authProvider(block -> block.value(acme.getValue())
                                .name(acme.getName())
                                .description(acme.getDescription())
                                .iconUrl(acme.getIconUrl())
                                .authUrl(acme.getAuthUrl())
                                .disconnectUrl(acme.getDisconnectUrl())
                                .isConnected(acme.getIsConnected())
                                .connectedIdentity(acme.getConnectedIdentity())
                                .connectedContext(acme.getConnectedContext())
                                .accessory(acme.getAccessory())))));
    }
}
