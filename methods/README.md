# Methods

An interface for querying information from and enacting change in a Slack workspace.

Read the [docs](https://docs.slack.dev/apis/web-api/) for explanations of concepts, or explore [reference](https://docs.slack.dev/reference/methods) pages for specific functionalities.

## Making a request

```sh
$ cd methods  # Navigate to the project root
$ slack app settings  # Create an app
$ vim src/main/java/chat/ChatPostMessage.java  # Edit arguments
$ export SLACK_TOKEN=xoxb-example  # Set if unchanged
$ mvn compile exec:java -Dexec.mainClass=chat.ChatPostMessage  # Make the request
```

## What's on call

### blocks

- **[blocks.validate](https://docs.slack.dev/reference/methods/blocks.validate)**: Validates blocks, messages, and views Block Kit JSON payloads. [Implementation](./src/main/java/blocks/BlocksValidate.java).

### chat

- **[chat.appendStream](https://docs.slack.dev/reference/methods/chat.appendStream)**: Appends text to an existing streaming conversation. [Implementation](./src/main/java/chat/ChatAppendStream.java).
- **[chat.postMessage](https://docs.slack.dev/reference/methods/chat.postmessage)**: Sends a message to a channel. [Implementation](./src/main/java/chat/ChatPostMessage.java).
- **[chat.startStream](https://docs.slack.dev/reference/methods/chat.startStream)**: Starts a new streaming conversation. [Implementation](./src/main/java/chat/ChatStartStream.java).
- **[chat.stopStream](https://docs.slack.dev/reference/methods/chat.stopStream)**: Stops a streaming conversation. [Implementation](./src/main/java/chat/ChatStopStream.java).

