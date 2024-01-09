plugins {
    kotlin("jvm")
}

group = "io.github.darkflamemasterdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("io.github.darkflamemasterdev:MatrixKotlin:1.1.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}