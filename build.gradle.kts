import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "github.com.rexfilius"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}


tasks.named<KotlinJvmCompile>("compileKotlin") {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

application {
    mainClass.set("MainKt")
}