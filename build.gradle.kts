import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
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
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<Jar>("jar") {
    from("src/main/annotations/")
}
