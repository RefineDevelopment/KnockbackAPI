plugins {
    id("java")
}

group = "xyz.refinedev.api"
version = "1.0.0"

dependencies {
    compileOnly(project(":api"))
    // KnockbackManager API dependency
    compileOnly(files("../lib/KnockbackManager-1.13.4.jar"))
}