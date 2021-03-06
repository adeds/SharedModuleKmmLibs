plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.serialization")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    val ktorVersion by System.getProperties()

    implementation(project(":domain"))
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
}