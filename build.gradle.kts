import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    maven
}

group = "flavor.pie"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spongepowered.org/maven/")
    }
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly("org.spongepowered:spongeapi:7.1.0")
    compileOnly("com.uchuhimo:konf:0.13.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
