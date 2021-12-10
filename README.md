# Log4j Patch

Adapted from [Glavo/log4j-patch](https://github.com/Glavo/log4j-patch) for log4j 2.0-beta9 (Used by Minecraft 1.7.2-1.11.2)

Resolve the RCE vulnerability caused by JNDI lookup in log4j 2.0~2.14.1. It is available under the MIT license.

This is a **non-intrusive** patch that allows you to block this vulnerability without modifying the program code/updating the dependent.
So you can use it to patch third-party programs, such as Minecraft.

The principle of the library is simple: 
It provides an empty `JndiLookup` to override the implementation in log4j. 
Log4j2 can handle this situation and safely disable JNDI lookup.

It is compatible with version 2.0-beta9 of log4j2.

## Usage

You can add it to the classpath by yourself, or you can use javaagent to inject it automatically.

### Use Java Agent

First, download the agent jar: [log4j-2.0-beta9-patch-agent-1.0.jar](https://github.com/Pineapplecake/log4j-patch/releases/download/v1.0/log4j-2.0-beta9-patch-agent-1.0.jar).

You only need to add the `-javaagent:log4j-patch-agent-1.0.jar` to the JVM parameter, and the agent will do everything automatically.

### Manual injection

Sometimes you may not want to use Java agent, such as when you need to generate native-image. You can download it directly from GitHub release:
[log4j-2.0-beta9-patch-1.0.jar](https://github.com/Pineapplecake/log4j-patch/releases/download/v1.0/log4j-2.0-beta9-patch-1.0.jar).

All you need to do is add it to the front of the classpath.

If you are using log4j2 as a Java module, use this JVM parameter instead of adding it to the classpath: 
`--patch-module org.apache.logging.log4j.core=log4j-2.0-beta9-patch-1.0.jar`.

## Check whether the replacement is successful

When JNDI lookup is disabled, any JNDI lookups that appear in the log will be replaced with ``(Disabled JNDI Lookup with key: <key>)``

in addition, if you use the agent, it will set the system property `org.glavo.log4j.patch.agent.patched` to `true` when the replacement is successful.
We can use the `jinfo` command line tool to observe the system properties of the JVM process.
