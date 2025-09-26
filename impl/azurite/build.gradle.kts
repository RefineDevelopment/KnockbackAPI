plugins {
    id("java")
}

group = "xyz.refinedev.api"
version = "1.0.0"

dependencies {
    compileOnly(project(":api"))
    compileOnly("dev.azurite.spigot:azurite-api:1.8.8-R0.1-SNAPSHOT")
}
