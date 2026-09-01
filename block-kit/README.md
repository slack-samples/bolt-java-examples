# Block Kit

The framework of visual components arranged to create app layouts.

Read the [docs](https://docs.slack.dev/block-kit/) to learn concepts behind these constructions, or explore [reference](https://docs.slack.dev/reference/block-kit) pages for attribute details.

## What's on display

### Blocks

- **[Actions](https://docs.slack.dev/reference/block-kit/blocks/actions-block)**: Holds multiple interactive elements. [Implementation](./src/main/java/blocks/Actions.java).
- **[Alert](https://docs.slack.dev/reference/block-kit/blocks/alert-block)**: Displays alerts, warnings, and informational messages. [Implementation](./src/main/java/blocks/Alert.java).
- **[Carousel](https://docs.slack.dev/reference/block-kit/blocks/carousel-block)**: Displays related card blocks in a horizontally-scrolling container. [Implementation](./src/main/java/blocks/Carousel.java).
- **[Card](https://docs.slack.dev/reference/block-kit/blocks/card-block)**: Displays content in a card. [Implementation](./src/main/java/blocks/Card.java).
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

### Block elements

- **[Broadcast](https://docs.slack.dev/reference/block-kit/block-elements/broadcast-element)**: Displays a broadcast mention such as here, channel, or everyone. [Implementation](./src/main/java/elements/Broadcast.java).
- **[Button](https://docs.slack.dev/reference/block-kit/block-elements/button-element)**: Allows users a direct path to performing basic actions. [Implementation](./src/main/java/elements/Button.java).
- **[Channel](https://docs.slack.dev/reference/block-kit/block-elements/channel-element)**: Renders as a mention of a channel. [Implementation](./src/main/java/elements/Channel.java).
- **[Color](https://docs.slack.dev/reference/block-kit/block-elements/color-element)**: Displays a color swatch from a hex value. [Implementation](./src/main/java/elements/Color.java).
- **[Date](https://docs.slack.dev/reference/block-kit/block-elements/date-element)**: Displays a formatted, localized date. [Implementation](./src/main/java/elements/Date.java).
- **[Date picker](https://docs.slack.dev/reference/block-kit/block-elements/date-picker-element)**: Allows users to select a date from a calendar style UI. [Implementation](./src/main/java/elements/DatePicker.java).
- **[Datetime picker](https://docs.slack.dev/reference/block-kit/block-elements/datetime-picker-element)**: Allows users to select both a date and a time of day. [Implementation](./src/main/java/elements/DatetimePicker.java).
- **[Email input](https://docs.slack.dev/reference/block-kit/block-elements/email-input-element)**: Allows user to enter an email into a single-line field. [Implementation](./src/main/java/elements/EmailInput.java).
- **[Emoji](https://docs.slack.dev/reference/block-kit/block-elements/emoji-element)**: Displays an emoji. [Implementation](./src/main/java/elements/Emoji.java).
- **[Feedback buttons](https://docs.slack.dev/reference/block-kit/block-elements/feedback-buttons-element)**: Buttons to indicate positive or negative feedback. [Implementation](./src/main/java/elements/FeedbackButtons.java).
- **[File input](https://docs.slack.dev/reference/block-kit/block-elements/file-input-element)**: Allows user to upload files. [Implementation](./src/main/java/elements/FileInput.java).
- **[Icon button](https://docs.slack.dev/reference/block-kit/block-elements/icon-button-element)**: An icon button to perform actions. [Implementation](./src/main/java/elements/IconButton.java).
- **[Image](https://docs.slack.dev/reference/block-kit/block-elements/image-element)**: Displays an image as part of a larger block of content. [Implementation](./src/main/java/elements/Image.java).
- **[Link](https://docs.slack.dev/reference/block-kit/block-elements/link-element)**: Displays a hyperlink. [Implementation](./src/main/java/elements/Link.java).
- **[Multi-select menu](https://docs.slack.dev/reference/block-kit/block-elements/multi-select-menu-element)**: Allows users to select multiple items from a list of options. [Implementation](./src/main/java/elements/MultiSelectMenu.java).
- **[Number input](https://docs.slack.dev/reference/block-kit/block-elements/number-input-element)**: Allows user to enter a number into a single-line field. [Implementation](./src/main/java/elements/NumberInput.java).
- **[Overflow menu](https://docs.slack.dev/reference/block-kit/block-elements/overflow-menu-element)**: Allows users to press a button to view a list of options. [Implementation](./src/main/java/elements/OverflowMenu.java).
- **[Plain-text input](https://docs.slack.dev/reference/block-kit/block-elements/plain-text-input-element)**: Allows users to enter freeform text data into a single-line or multi-line field. [Implementation](./src/main/java/elements/PlainTextInput.java).
- **[Radio button group](https://docs.slack.dev/reference/block-kit/block-elements/radio-button-group-element)**: Allows users to choose one item from a list of possible options. [Implementation](./src/main/java/elements/RadioButtons.java).
- **[Rich text input](https://docs.slack.dev/reference/block-kit/block-elements/rich-text-input-element)**: Allows users to enter formatted text in a WYSIWYG composer, offering the same messaging writing experience as in Slack. [Implementation](./src/main/java/elements/RichTextInput.java).
- **[Rich text list](https://docs.slack.dev/reference/block-kit/block-elements/rich-text-list-element)**: Displays a list of rich text items. [Implementation](./src/main/java/elements/RichTextList.java).
- **[Rich text preformatted](https://docs.slack.dev/reference/block-kit/block-elements/rich-text-preformatted-element)**: Displays a preformatted rich text element. [Implementation](./src/main/java/elements/RichTextPreformatted.java).
- **[Rich text quote](https://docs.slack.dev/reference/block-kit/block-elements/rich-text-quote-element)**: Displays a rich text quote block. [Implementation](./src/main/java/elements/RichTextQuote.java).
- **[Rich text section](https://docs.slack.dev/reference/block-kit/block-elements/rich-text-section-element)**: A section element that holds rich text elements. [Implementation](./src/main/java/elements/RichTextSection.java).
- **[Select menu](https://docs.slack.dev/reference/block-kit/block-elements/select-menu-element)**: Allows users to choose an option from a drop down menu. [Implementation](./src/main/java/elements/SelectMenu.java).
- **[Team](https://docs.slack.dev/reference/block-kit/block-elements/team-element)**: Renders as a mention of a workspace or team. [Implementation](./src/main/java/elements/Team.java).
- **[Text](https://docs.slack.dev/reference/block-kit/block-elements/text-element)**: Displays text, optionally with styling. [Implementation](./src/main/java/elements/Text.java).
- **[Time picker](https://docs.slack.dev/reference/block-kit/block-elements/time-picker-element)**: Allows users to enter numerical data into a single-line field. [Implementation](./src/main/java/elements/TimePicker.java).
- **[URL input](https://docs.slack.dev/reference/block-kit/block-elements/url-input-element)**: Allows user to enter a URL into a single-line field. [Implementation](./src/main/java/elements/UrlInput.java).
- **[User](https://docs.slack.dev/reference/block-kit/block-elements/user-element)**: Renders as a mention of a user. [Implementation](./src/main/java/elements/User.java).
- **[Usergroup](https://docs.slack.dev/reference/block-kit/block-elements/usergroup-element)**: Renders as a mention of a user group. [Implementation](./src/main/java/elements/UserGroup.java).
- **[Workflow button](https://docs.slack.dev/reference/block-kit/block-elements/workflow-button-element)**: Allows users to run a link trigger with customizable inputs. [Implementation](./src/main/java/elements/WorkflowButton.java).

