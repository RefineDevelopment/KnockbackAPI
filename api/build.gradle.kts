plugins {
    id("java-library")
}

group = "xyz.refinedev.api"
version = "1.0.0"

dependencies {
    compileOnlyApi("io.papermc.paper:paper-api:1.8.8-R0.1-SNAPSHOT")
    compileOnlyApi("org.jetbrains:annotations:24.0.1")
}