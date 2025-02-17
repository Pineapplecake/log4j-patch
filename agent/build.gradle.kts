plugins {
    java
}

tasks.jar {
    archiveBaseName.set("log4j-2.0-beta9-patch-agent")
    manifest.attributes(
        "Premain-Class" to "org.glavo.log4j.patch.agent.Log4jAgent"
    )
}

tasks.processResources {
    dependsOn(rootProject.tasks.compileJava)

    into("org/glavo/log4j/patch/agent") {
        from(rootProject.file("build/classes/java/main/org/apache/logging/log4j/core/lookup/JndiLookup.class"))
        rename("JndiLookup.class", "JndiLookup.class.bin")
    }
}

dependencies {
    compileOnly(rootProject)
}
