# Methods

Individual Slack Web API method calls with the `slack-api-client`.

Read the [docs](https://docs.slack.dev/reference/methods) to explore every method, or explore implementations of specific families.

## What's on display

### chat

- **[chat.postMessage](https://docs.slack.dev/reference/methods/chat.postmessage)**: Sends a message to a channel. [Implementation](./src/main/java/chat/ChatPostMessage.java). Scopes: `chat:write`.

## Running an example

Set a bot token and run an example class directly:

```sh
export SLACK_TOKEN="xoxb-your-token"
mvn compile exec:java -Dexec.mainClass=chat.ChatPostMessage
```

