plugins {
    java
}

allprojects {
    apply {
        plugin("java")
    }

    group = "org.glavo"
    version = "1.0"

    tasks.compileJava {
        sourceCompatibility = "6"
        targetCompatibility = "6"
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.0-beta9")
}

tasks.withType<GenerateModuleMetadata>().configureEach {
    enabled = false
}
