package acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.slack.api.RequestConfigurator;
import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.ActionContext;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.bolt.request.RequestHeaders;
import com.slack.api.bolt.request.builtin.BlockActionRequest;
import com.slack.api.bolt.response.Response;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest;
import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionRequestAuthRequest.PrimaryProvider;
import com.slack.api.methods.request.apps.user.connection.AppsUserConnectionUpdateRequest;
import com.slack.api.methods.request.views.ViewsPublishRequest;
import com.slack.api.model.block.AuthProviderBlock;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.event.AppHomeOpenedEvent;
import com.slack.api.model.event.Event;
import com.slack.api.model.event.UserConnectionStatusRequestedEvent;
import com.slack.api.util.json.GsonFactory;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MainTest {
    private TempConnections connections;

    @Mock
    private MethodsClient client;

    @Captor
    private ArgumentCaptor<
                    RequestConfigurator<
                            AppsUserConnectionRequestAuthRequest.AppsUserConnectionRequestAuthRequestBuilder>>
            requestAuth;

    @Captor
    private ArgumentCaptor<RequestConfigurator<AppsUserConnectionUpdateRequest.AppsUserConnectionUpdateRequestBuilder>>
            update;

    @Captor
    private ArgumentCaptor<RequestConfigurator<ViewsPublishRequest.ViewsPublishRequestBuilder>> publish;

    private ActionContext actionContext;
    private EventContext eventContext;

    @BeforeEach
    public void setUp() throws Exception {
        connections = new TempConnections();
        actionContext = spy(new ActionContext());
        eventContext = spy(new EventContext());
        lenient().doReturn(client).when(actionContext).client();
        lenient().doReturn(client).when(eventContext).client();
    }

    @AfterEach
    public void tearDown() throws Exception {
        connections.close();
    }

    @Test
    public void testAppHomeOpenedShowsTheConnection() throws Exception {
        Connections.connect("U0ADA");
        AppHomeOpenedEvent event = new AppHomeOpenedEvent();
        event.setUser("U0ADA");

        Main.appHomeOpenedCallback(payload(event), eventContext);

        assertEquals("U0ADA", published().getUserId());
        assertTrue(homeBlock().getIsConnected());
    }

    @Test
    public void testConnectSavesAndShowsTheConnection() throws Exception {
        Response response = Main.connectCallback(buttonClick("acme"), actionContext);

        assertEquals(200, response.getStatusCode());
        assertTrue(Connections.isConnected("U0ADA"));
        assertTrue(sentProvider().getIsConnected());
        assertTrue(homeBlock().getIsConnected());
    }

    @Test
    public void testDisconnectForgetsAndShowsTheConnection() throws Exception {
        Connections.connect("U0ADA");

        Response response = Main.disconnectCallback(buttonClick("acme"), actionContext);

        assertEquals(200, response.getStatusCode());
        assertFalse(Connections.isConnected("U0ADA"));
        assertFalse(sentProvider().getIsConnected());
        assertFalse(homeBlock().getIsConnected());
    }

    @Test
    public void testConnectIgnoresAnotherProvider() throws Exception {
        Response response = Main.connectCallback(buttonClick("wile-e-coyote"), actionContext);

        assertEquals(200, response.getStatusCode());
        assertFalse(Connections.isConnected("U0ADA"));
        verifyNoInteractions(client);
    }

    @Test
    public void testDisconnectIgnoresAnotherProvider() throws Exception {
        Connections.connect("U0ADA");

        Response response = Main.disconnectCallback(buttonClick("wile-e-coyote"), actionContext);

        assertEquals(200, response.getStatusCode());
        assertTrue(Connections.isConnected("U0ADA"));
        verifyNoInteractions(client);
    }

    @Test
    public void testUserConnectionConnectOpensTheModal() throws Exception {
        UserConnectionEvent event =
                userConnection("{\"subtype\":\"connect\",\"user\":\"U0ADA\",\"trigger_id\":\"123.456.abc\"}");

        Main.userConnectionCallback(payload(event), eventContext);

        AppsUserConnectionRequestAuthRequest request = sentRequestAuth();
        assertEquals("123.456.abc", request.getTriggerId());
        assertFalse(request.getPrimaryProvider().getIsConnected());
    }

    @Test
    public void testUserConnectionDisconnectIsIgnored() throws Exception {
        UserConnectionEvent event =
                userConnection("{\"subtype\":\"disconnect\",\"user\":\"U0ADA\",\"trigger_id\":\"123.456.abc\"}");

        Main.userConnectionCallback(payload(event), eventContext);

        verifyNoInteractions(client);
    }

    @Test
    public void testStatusRequestedReportsConnectedUsers() throws Exception {
        Connections.connect("U0ADA");

        Main.userConnectionStatusRequestedCallback(payload(statusRequested("U0ADA")), eventContext);

        AppsUserConnectionUpdateRequest request = sentUpdate();
        assertEquals("U0ADA", request.getUserId());
        assertEquals("connected", request.getStatus());
    }

    @Test
    public void testStatusRequestedReportsUnknownUsersAsDisconnected() throws Exception {
        Main.userConnectionStatusRequestedCallback(payload(statusRequested("U0ADA")), eventContext);

        AppsUserConnectionUpdateRequest request = sentUpdate();
        assertEquals("U0ADA", request.getUserId());
        assertEquals("disconnected", request.getStatus());
    }

    private AppsUserConnectionRequestAuthRequest sentRequestAuth() throws Exception {
        verify(client).appsUserConnectionRequestAuth(requestAuth.capture());
        return requestAuth
                .getValue()
                .configure(AppsUserConnectionRequestAuthRequest.builder())
                .build();
    }

    private PrimaryProvider sentProvider() throws Exception {
        return sentRequestAuth().getPrimaryProvider();
    }

    private AppsUserConnectionUpdateRequest sentUpdate() throws Exception {
        verify(client).appsUserConnectionUpdate(update.capture());
        return update.getValue()
                .configure(AppsUserConnectionUpdateRequest.builder())
                .build();
    }

    private ViewsPublishRequest published() throws Exception {
        verify(client).viewsPublish(publish.capture());
        return publish.getValue().configure(ViewsPublishRequest.builder()).build();
    }

    private AuthProviderBlock homeBlock() throws Exception {
        List<LayoutBlock> blocks = published().getView().getBlocks();
        return (AuthProviderBlock) blocks.get(blocks.size() - 1);
    }

    private static BlockActionRequest buttonClick(String value) {
        String payload = "{\"user\":{\"id\":\"U0ADA\"},\"actions\":[{\"value\":\"%s\"}]}".formatted(value);
        return new BlockActionRequest(null, payload, new RequestHeaders(Map.of()));
    }

    private static UserConnectionEvent userConnection(String json) {
        return GsonFactory.createSnakeCase().fromJson(json, UserConnectionEvent.class);
    }

    private static UserConnectionStatusRequestedEvent statusRequested(String userId) {
        UserConnectionStatusRequestedEvent event = new UserConnectionStatusRequestedEvent();
        event.setUser(userId);
        return event;
    }

    @SuppressWarnings("unchecked")
    private static <E extends Event> EventsApiPayload<E> payload(E event) {
        EventsApiPayload<E> payload = mock(EventsApiPayload.class);
        when(payload.getEvent()).thenReturn(event);
        return payload;
    }
}
