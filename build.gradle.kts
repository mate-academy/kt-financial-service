plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

group = "mate.academy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // опционально, но полезно
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    baseline = file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt
}
