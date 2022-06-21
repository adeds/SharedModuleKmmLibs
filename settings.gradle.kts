pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "SharedModuleKmmLibs"
include(":shared")
include(":domain")
include(":data")
