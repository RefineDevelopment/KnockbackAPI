plugins {
    id("io.freefair.lombok") version "8.12.1"
}

group = "xyz.refinedev.api"
version = "1.0.0"

subprojects {
    apply {
        plugin("maven-publish")
        plugin("io.freefair.lombok")

        repositories {
            mavenCentral()
            mavenLocal()

            maven("https://repo.aikar.co/content/groups/aikar/")
            maven("https://repo.codemc.io/repository/maven-releases/")
            maven("https://repo.codemc.io/repository/maven-snapshots/")
            maven("https://papermc.io/repo/repository/maven-public/")
            maven("https://maven.refinedev.xyz/public-repo")
            maven("https://repo.minebench.de/")
        }

        tasks.withType(JavaCompile::class.java) {
            options.encoding = "UTF-8"
            options.release.set(8)
            options.compilerArgs.add("-Xlint:-options")
        }
    }
}