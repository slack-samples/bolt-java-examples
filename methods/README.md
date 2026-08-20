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

### agents

- **[agents.sessions.rename](https://docs.slack.dev/reference/methods/agents.sessions.rename)**: Rename an agent session. [Implementation](./src/main/java/agents/sessions/AgentsSessionsRename.java).
- **[agents.sessions.setStatus](https://docs.slack.dev/reference/methods/agents.sessions.setStatus)**: Set an agent session's lifecycle status, creating the session if needed. [Implementation](./src/main/java/agents/sessions/AgentsSessionsSetStatus.java).

### chat

- **[chat.postMessage](https://docs.slack.dev/reference/methods/chat.postmessage)**: Sends a message to a channel. [Implementation](./src/main/java/chat/ChatPostMessage.java).

