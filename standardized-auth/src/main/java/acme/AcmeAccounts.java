package acme;

import com.slack.api.bolt.context.Context;
import com.slack.api.bolt.model.Installer;
import com.slack.api.bolt.service.InstallationService;
import java.util.Optional;

public final class AcmeAccounts {
    private final InstallationService installations;

    public AcmeAccounts(InstallationService installations) {
        this.installations = installations;
    }

    public Optional<Installer> find(Context context, String userId) {
        return Optional.ofNullable(installations.findInstaller(context.getEnterpriseId(), context.getTeamId(), userId))
                .filter(installer -> installer.getInstallerUserAccessToken() != null);
    }

    public Optional<String> forget(Context context, String userId) {
        Optional<Installer> account = find(context, userId);
        account.ifPresent(this::delete);
        return account.map(Installer::getInstallerUserAccessToken);
    }

    private void delete(Installer installer) {
        try {
            installations.deleteInstaller(installer);
        } catch (Exception error) {
            throw new IllegalStateException("Failed to forget the Acme account", error);
        }
    }
}
