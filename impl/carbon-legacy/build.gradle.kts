plugins {
    id("java")
}

group = "xyz.refinedev.api"
version = "1.0.0"

dependencies {
    compileOnly(project(":api"))
    compileOnly("xyz.refinedev.spigot:CarbonSpigotAPI:1.1")
}
