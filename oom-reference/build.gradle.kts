import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    application
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

    // mock & kotest & springboot-test
    testImplementation("io.mockk:mockk:1.12.2")
    testImplementation("io.kotest:kotest-assertions-core:5.1.0")
    testImplementation("io.kotest:kotest-property:5.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        this.exclude(group ="org.junit.vintage", module = "junit-vintage-engine")
    }
}

application {
    // https://docs.gradle.org/current/userguide/application_plugin.html
    // gradle task : bootRun
    applicationDefaultJvmArgs = listOf(
        "-Xms400m",
        "-Xmx400m",
        "-Xlog:gc::time",
        "-Xlog:gc*:file=${project.rootDir}/mygc.log,filecount=5,filesize=50m:time",
        "-XX:+HeapDumpOnOutOfMemoryError",
        "-XX:HeapDumpPath=${project.rootDir}"
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
