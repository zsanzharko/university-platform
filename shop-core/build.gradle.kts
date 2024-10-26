plugins {
    `java-library`
    checkstyle
}

version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = file("$rootDir/config/checkstyle/checkstyle.xml")
}

tasks.withType<Checkstyle>().configureEach {
    minHeapSize = "200m"
    maxHeapSize = "1g"
}