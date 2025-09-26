plugins {
    id("java")
    id("com.gradleup.shadow") version "9.0.0-beta8"
}

group = "xyz.refinedev.api"
version = "1.0.0"

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val outputDir = layout.projectDirectory.dir("../jars")

tasks {
    jar {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set(project.version.toString())
        destinationDirectory.set(outputDir)
    }

    named<Jar>("sourcesJar") {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set(project.version.toString())
        destinationDirectory.set(outputDir)
    }

    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("")
        destinationDirectory.set(outputDir)

        exclude("META-INF/**")
        exclude("module-info.class")
    }

    build {
        dependsOn(shadowJar)
    }
}

dependencies {
    implementation(project(":api"))
    implementation(project(":impl:carbon"))
    implementation(project(":impl:carbon-legacy"))
    implementation(project(":impl:imanity"))
    implementation(project(":impl:foxspigot"))
    implementation(project(":impl:azurite"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["shadow"])

            groupId = group.toString()
            artifactId = rootProject.name.toString()
            version = version.toString()
        }
    }

    repositories {
        mavenLocal()

        maven {
            name = "refine-public"
            url = uri("https://maven.refinedev.xyz/public-repo")
            credentials {
                username = findProperty("mavenUsername") as String? ?: ""
                password = findProperty("mavenPassword") as String? ?: ""
            }
        }
    }
}