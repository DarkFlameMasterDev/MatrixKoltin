import com.vanniktech.maven.publish.SonatypeHost

plugins {
  kotlin("jvm")
  id("com.vanniktech.maven.publish") version "0.27.0"
}

group = "io.github.DarkFlameMasterDev"
version = "1.1"

mavenPublishing {
  publishToMavenCentral(SonatypeHost.S01)

  signAllPublications()

  coordinates("io.github.DarkFlameMasterDev", "MatrixKotlin", "1.1T")

  pom {
    name.set("MatrixKotlin")
    description.set("a kotlin library for matrix calculations")
    inceptionYear.set("2024")
    url.set("https://github.com/darkflamemasterdev/MatrixKotlin")
    licenses {
      license {
        name.set("GNU Lesser General Public License, Version 3.0")
        url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
        distribution.set("https://www.gnu.org/licenses/gpl-3.0.txt")
      }
    }
    developers {
      developer {
        id.set("DarkFlameMasterDev")
        name.set("lucas")
        url.set("https://github.com/darkflamemasterdev")
      }
    }
    scm {
      url.set("https://github.com/darkflamemasterdev/MatrixKotlin")
      connection.set("scm:git:git://github.com/darkflamemasterdev/MatrixKotlin.git")
      developerConnection.set("scm:git:ssh://git@github.com/darkflamemasterdev/MatrixKotlin.git")
    }
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.vanniktech:gradle-maven-publish-plugin:0.27.0")
}

kotlin {
  jvmToolchain(11)
}