# Maintainers Guide

Let's hope to have matching examples of documentation and reference for various runtimes be consistent!

- **[Development](#development)**: Making changes alongside the Java Slack SDK.
- **[Commands](#commands)**: Reference to running example code of this project.
- **[Structure](#structure)**: Adding examples for features of the Slack Platform.

## Development

Bringing ongoing changes from the [Java Slack SDK](https://github.com/slackapi/java-slack-sdk) requires [building from source](https://docs.slack.dev/tools/java-slack-sdk/guides/web-api-client-setup#build-from-source) with these commands:

```sh
$ git clone git@github.com:slackapi/java-slack-sdk.git
$ cd java-slack-sdk
$ mvn install -Dmaven.test.skip=true
```

This adds a snapshot to the `$HOME/.m2` path that are used after updating the versions found in a `pom.xml` file:

```sh
$ git clone git@github.com:slack-samples/bolt-java-examples.git
$ cd bolt-java-examples
$ cd block-kit  # Navigate to whatever example
$ vim pom.xml
```

```diff
    <dependency>
      <groupId>com.slack.api</groupId>
      <artifactId>slack-api-model</artifactId>
-     <version>1.45.4</version>
+     <version>1.45.4-SNAPSHOT</version>
    </dependency>
```

## Commands

Each example has matching commands to run tests:

```sh
$ mvn --batch-mode spotless:check
$ mvn --batch-mode test -Dspotless.apply.skip
```

## Structure

New code snippets or samples added should match the structure of the [docs.slack.dev](https://docs.slack.dev) site:

```txt
|- .github
   |- dependabot.yml  # https://docs.github.com/en/code-security/dependabot/dependabot-version-updates/controlling-dependencies-updated#defining-multiple-locations-for-manifest-files
|- block-kit
   |- blocks          # https://docs.slack.dev/reference/block-kit/blocks
   |- formatting      # https://docs.slack.dev/block-kit/formatting-with-rich-text
|- messaging
   |- sending         # https://docs.slack.dev/messaging/sending-and-scheduling-messages
   |- work-objects    # https://docs.slack.dev/messaging/work-objects
```

Some pages might reference distinct examples needing unique app manifests. These should appear in separate nested directories for a minimal demonstration.

Certain features or demonstrations might not have a clear example on the docs site. Discussions with the kind documentation team ought be started if so! We hope folks find relevant examples through those pages.

A goal of this project is to be a source of tested reference.
