# Maintainers guide

Let's hope to have matching examples of documentation and reference for various runtimes be consistent!

## Development

Bringing ongoing changes from the [Java Slack SDK](https://github.com/slackapi/java-slack-sdk) requires [building from source](https://docs.slack.dev/tools/java-slack-sdk/guides/web-api-client-setup#build-from-source) with these commands:

```sh
$ git clone git@github.com:slackapi/java-slack-sdk.git
$ cd java-slack-sdk
$ mvn install -Dmaven.test.skip=true
```

This adds a snapshot to the `$HOME/.m2` path that are used after updating the versions found in a `pom.xml` file.

```diff
    <dependency>
      <groupId>com.slack.api</groupId>
      <artifactId>slack-api-model</artifactId>
-     <version>1.45.4</version>
+     <version>1.45.4-SNAPSHOT</version>
    </dependency>
```
