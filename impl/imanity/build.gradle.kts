plugins {
    id("java")
}

group = "xyz.refinedev.api"
version = "1.0.0"

repositories {
    maven("https://repo.imanity.dev/imanity-libraries/")
}

dependencies {
    compileOnly(project(":api"))
    compileOnly("org.imanity.imanityspigot:api:2025.3.3")
}
