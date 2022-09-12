import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val exposedVersion: String by project
val mysqlConnectorVersion: String by project
val javaFakerVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "io.kraftsman"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("mysql:mysql-connector-java:$mysqlConnectorVersion")
    implementation("com.github.javafaker:javafaker:$javaFakerVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}
