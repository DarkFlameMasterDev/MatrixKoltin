plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.czb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}