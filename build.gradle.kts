plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

group = "mate.academy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.github.com/gradle/toolchains") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    baseline = file("$projectDir/config/baseline.xml")
}
