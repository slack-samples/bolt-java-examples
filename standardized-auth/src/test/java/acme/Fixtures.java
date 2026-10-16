package acme;

import com.slack.api.bolt.context.Context;
import com.slack.api.bolt.context.builtin.ActionContext;
import com.slack.api.bolt.model.Installer;
import com.slack.api.bolt.model.builtin.DefaultInstaller;

public final class Fixtures {
    private Fixtures() {}

    public static Installer installer(String userId, String userToken) {
        return installer(null, "T0001", userId, userToken);
    }

    public static Installer installer(String enterpriseId, String teamId, String userId, String userToken) {
        return DefaultInstaller.builder()
                .appId("A0001")
                .enterpriseId(enterpriseId)
                .teamId(teamId)
                .isEnterpriseInstall(teamId == null)
                .installerUserId(userId)
                .installerUserAccessToken(userToken)
                .botUserId("U0BOT")
                .botId("B0001")
                .botAccessToken("xoxb-test-bot")
                .installedAt(System.currentTimeMillis())
                .build();
    }

    public static Context context() {
        return context(null, "T0001");
    }

    public static Context context(String enterpriseId, String teamId) {
        ActionContext context = new ActionContext();
        context.setEnterpriseId(enterpriseId);
        context.setTeamId(teamId);
        return context;
    }
}
