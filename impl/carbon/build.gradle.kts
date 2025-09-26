plugins {
    id("java")
}

group = "xyz.refinedev.api"
version = "1.0.0"

dependencies {
    compileOnly(project(":api"))
    compileOnly("xyz.refinedev.spigot:Carbon-API:1.8.8-R0.1-SNAPSHOT")
}