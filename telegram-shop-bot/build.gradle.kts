plugins {
    application
    checkstyle
    `java`
}

version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shop-core"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.telegrambots.longpolling)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "kz.zsanzharko.shopbot.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
