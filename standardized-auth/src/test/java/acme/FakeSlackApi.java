package acme;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import com.slack.api.methods.MethodsConfig;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class FakeSlackApi implements AutoCloseable {
    public record Call(String method, String token, Map<String, String> params) {}

    private static final byte[] REPLY =
            "{\"ok\":true,\"user\":\"ada\",\"team\":\"Acme Corp\"}".getBytes(StandardCharsets.UTF_8);

    private final HttpServer server;
    private final List<Call> calls = new CopyOnWriteArrayList<>();

    public FakeSlackApi() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/api/", this::record);
        server.start();
    }

    public Slack slack() {
        MethodsConfig methodsConfig = new MethodsConfig();
        methodsConfig.setStatsEnabled(false);
        SlackConfig config = new SlackConfig();
        config.setMethodsConfig(methodsConfig);
        config.setMethodsEndpointUrlPrefix(
                "http://localhost:" + server.getAddress().getPort() + "/api/");
        return Slack.getInstance(config);
    }

    public List<Call> calls() {
        return calls;
    }

    public List<String> methods() {
        return calls.stream().map(Call::method).toList();
    }

    public Call call(String method) {
        return calls.stream()
                .filter(call -> call.method().equals(method))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void close() {
        server.stop(0);
    }

    private void record(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestURI().getPath().substring("/api/".length());
        String authorization = exchange.getRequestHeaders().getFirst("Authorization");
        String token = authorization == null ? null : authorization.substring("Bearer ".length());
        String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        calls.add(new Call(method, token, formParams(body)));
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, REPLY.length);
        exchange.getResponseBody().write(REPLY);
        exchange.close();
    }

    private static Map<String, String> formParams(String body) {
        if (body.isEmpty()) {
            return Map.of();
        }
        return Arrays.stream(body.split("&"))
                .map(pair -> pair.split("=", 2))
                .collect(Collectors.toMap(pair -> decode(pair[0]), pair -> decode(pair[1])));
    }

    private static String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }
}
