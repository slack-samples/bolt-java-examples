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

### Block elements

- **[Button](https://docs.slack.dev/reference/block-kit/block-elements/button-element)**: Allows users a direct path to performing basic actions. [Implementation](./src/main/java/blockelements/Button.java).
- **[Date picker](https://docs.slack.dev/reference/block-kit/block-elements/date-picker-element)**: Allows users to select a date from a calendar style UI. [Implementation](./src/main/java/blockelements/DatePicker.java).
- **[Datetime picker](https://docs.slack.dev/reference/block-kit/block-elements/datetime-picker-element)**: Allows users to select both a date and a time of day. [Implementation](./src/main/java/blockelements/DatetimePicker.java).
- **[Email input](https://docs.slack.dev/reference/block-kit/block-elements/email-input-element)**: Allows user to enter an email into a single-line field. [Implementation](./src/main/java/blockelements/EmailInput.java).
- **[File input](https://docs.slack.dev/reference/block-kit/block-elements/file-input-element)**: Allows user to upload files. [Implementation](./src/main/java/blockelements/FileInput.java).
- **[Image](https://docs.slack.dev/reference/block-kit/block-elements/image-element)**: Displays an image as part of a larger block of content. [Implementation](./src/main/java/blockelements/Image.java).
- **[Multi-select menu](https://docs.slack.dev/reference/block-kit/block-elements/multi-select-menu-element)**: Allows users to select multiple items from a list of options. [Implementation](./src/main/java/blockelements/MultiSelectMenu.java).
- **[Number input](https://docs.slack.dev/reference/block-kit/block-elements/number-input-element)**: Allows user to enter a number into a single-line field. [Implementation](./src/main/java/blockelements/NumberInput.java).
- **[Overflow menu](https://docs.slack.dev/reference/block-kit/block-elements/overflow-menu-element)**: Allows users to press a button to view a list of options. [Implementation](./src/main/java/blockelements/OverflowMenu.java).
- **[Plain-text input](https://docs.slack.dev/reference/block-kit/block-elements/plain-text-input-element)**: Allows users to enter freeform text data into a single-line or multi-line field. [Implementation](./src/main/java/blockelements/PlainTextInput.java).
- **[Radio button group](https://docs.slack.dev/reference/block-kit/block-elements/radio-button-group-element)**: Allows users to choose one item from a list of possible options. [Implementation](./src/main/java/blockelements/RadioButtons.java).
- **[Select menu](https://docs.slack.dev/reference/block-kit/block-elements/select-menu-element)**: Allows users to choose an option from a drop down menu. [Implementation](./src/main/java/blockelements/SelectMenu.java).
- **[Time picker](https://docs.slack.dev/reference/block-kit/block-elements/time-picker-element)**: A time picker element; on desktop a dropdown with free-text entry, on mobile the native time picker UI. [Implementation](./src/main/java/blockelements/TimePicker.java).
- **[URL input](https://docs.slack.dev/reference/block-kit/block-elements/url-input-element)**: Allows user to enter a URL into a single-line field. [Implementation](./src/main/java/blockelements/UrlInput.java).
- **[Workflow button](https://docs.slack.dev/reference/block-kit/block-elements/workflow-button-element)**: Allows users to run a link trigger with customizable inputs. [Implementation](./src/main/java/blockelements/WorkflowButton.java).

