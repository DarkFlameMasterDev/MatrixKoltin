plugins {
  kotlin("jvm") version "1.9.21"
}

group = "io.github.DarkFlameMasterDev"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  implementation(project(":MatrixKotlin"))
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(11)
}