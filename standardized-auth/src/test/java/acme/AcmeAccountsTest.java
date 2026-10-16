package acme;

import static acme.Fixtures.context;
import static acme.Fixtures.installer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.service.InstallationService;
import com.slack.api.bolt.service.builtin.FileInstallationService;
import java.nio.file.Path;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class AcmeAccountsTest {
    @TempDir
    Path directory;

    private InstallationService installations;
    private AcmeAccounts accounts;

    @BeforeEach
    public void setUp() {
        AppConfig config = AppConfig.builder().clientId("111.222").build();
        installations = new FileInstallationService(config, directory.toString());
        accounts = new AcmeAccounts(installations);
    }

    @Test
    public void testUsersWhoNeverInstalledHaveNoAccount() {
        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
    }

    @Test
    public void testInstallationsWithoutAUserTokenAreNotAccounts() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", null));

        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
    }

    @Test
    public void testFindsTheAccountOfAUserWhoConnected() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));

        assertEquals(
                "xoxp-test-ada", accounts.find(context(), "U0ADA").orElseThrow().getInstallerUserAccessToken());
    }

    @Test
    public void testFindsOrgWideAccountsFromAnyWorkspaceInTheOrg() throws Exception {
        installations.saveInstallerAndBot(installer("E0001", null, "U0ADA", "xoxp-test-ada"));

        assertTrue(accounts.find(context("E0001", "T0002"), "U0ADA").isPresent());
    }

    @Test
    public void testForgetReturnsTheTokenAndKeepsOtherUsersConnected() throws Exception {
        installations.saveInstallerAndBot(installer("U0ADA", "xoxp-test-ada"));
        installations.saveInstallerAndBot(installer("U0BOB", "xoxp-test-bob"));

        assertEquals(Optional.of("xoxp-test-ada"), accounts.forget(context(), "U0ADA"));
        assertEquals(Optional.empty(), accounts.find(context(), "U0ADA"));
        assertTrue(accounts.find(context(), "U0BOB").isPresent());
    }

    @Test
    public void testForgetsOrgWideAccounts() throws Exception {
        installations.saveInstallerAndBot(installer("E0001", null, "U0ADA", "xoxp-test-ada"));

        assertEquals(Optional.of("xoxp-test-ada"), accounts.forget(context("E0001", "T0002"), "U0ADA"));
        assertEquals(Optional.empty(), accounts.find(context("E0001", "T0002"), "U0ADA"));
    }

    @Test
    public void testForgettingAUserWithoutAnAccountReturnsNothing() {
        assertEquals(Optional.empty(), accounts.forget(context(), "U0ADA"));
    }
}
