# Block Kit

The framework of visual components arranged to create app layouts.

Read the [docs](https://docs.slack.dev/block-kit/) to learn concepts behind these constructions, or explore [reference](https://docs.slack.dev/reference/block-kit) pages for attribute details.

## What's on display

### Blocks

- **[Actions](https://docs.slack.dev/reference/block-kit/blocks/actions-block)**: Holds multiple interactive elements. [Implementation](./src/main/java/blocks/Actions.java).
- **[Context](https://docs.slack.dev/reference/block-kit/blocks/context-block)**: Provides contextual info, which can include both images and text. [Implementation](./src/main/java/blocks/Context.java).
- **[Divider](https://docs.slack.dev/reference/block-kit/blocks/divider-block)**: Visually separates pieces of info inside of a message. [Implementation](./src/main/java/blocks/Divider.java).
- **[File](https://docs.slack.dev/reference/block-kit/blocks/file-block)**: Displays info about remote files. [Implementation](./src/main/java/blocks/File.java).
- **[Header](https://docs.slack.dev/reference/block-kit/blocks/header-block)**: Displays a larger-sized text. [Implementation](./src/main/java/blocks/Header.java).
- **[Image](https://docs.slack.dev/reference/block-kit/blocks/image-block)**: Displays an image. [Implementation](./src/main/java/blocks/Image.java).
- **[Input](https://docs.slack.dev/reference/block-kit/blocks/input-block)**: Collects information from users via elements. [Implementation](./src/main/java/blocks/Input.java).
- **[Markdown](https://docs.slack.dev/reference/block-kit/blocks/markdown-block)**: Displays formatted markdown. [Implementation](./src/main/java/blocks/Markdown.java).
- **[Rich text](https://docs.slack.dev/reference/block-kit/blocks/rich-text-block)**: Displays formatted, structured representation of text. [Implementation](./src/main/java/blocks/RichText.java).
- **[Section](https://docs.slack.dev/reference/block-kit/blocks/section-block)**: Displays text, possibly alongside elements. [Implementation](./src/main/java/blocks/Section.java).
- **[Video](https://docs.slack.dev/reference/block-kit/blocks/video-block)**: Displays an embedded video player. [Implementation](./src/main/java/blocks/Video.java).

### Composition objects

- **[Confirmation dialog](https://docs.slack.dev/reference/block-kit/composition-objects/confirmation-dialog-object)**: Defines a dialog that adds a confirmation step to interactive elements. [Implementation](./src/main/java/compositions/ConfirmationDialog.java).
- **[Conversation filter](https://docs.slack.dev/reference/block-kit/composition-objects/conversation-filter-object)**: Defines a filter for the list of options in a conversation selector menu. [Implementation](./src/main/java/compositions/ConversationFilter.java).
- **[Dispatch action configuration](https://docs.slack.dev/reference/block-kit/composition-objects/dispatch-action-configuration-object)**: Defines when a plain-text input element will return a `block_actions` interaction payload. [Implementation](./src/main/java/compositions/DispatchActionConfiguration.java).
- **[Option group](https://docs.slack.dev/reference/block-kit/composition-objects/option-group-object)**: Defines a way to group options in a menu. [Implementation](./src/main/java/compositions/OptionGroup.java).
- **[Option](https://docs.slack.dev/reference/block-kit/composition-objects/option-object)**: Defines a single item in a number of item selection elements. [Implementation](./src/main/java/compositions/Option.java).
- **[Slack file](https://docs.slack.dev/reference/block-kit/composition-objects/slack-file-object)**: Defines an object containing Slack file information to be used in an image block or image element. [Implementation](./src/main/java/compositions/SlackFile.java).
- **[Text](https://docs.slack.dev/reference/block-kit/composition-objects/text-object)**: Defines an object containing some text. [Implementation](./src/main/java/compositions/Text.java).
- **[Trigger](https://docs.slack.dev/reference/block-kit/composition-objects/trigger-object)**: Defines an object containing trigger information. [Implementation](./src/main/java/compositions/Trigger.java).
- **[Workflow](https://docs.slack.dev/reference/block-kit/composition-objects/workflow-object)**: Defines an object containing workflow information. [Implementation](./src/main/java/compositions/Workflow.java).

