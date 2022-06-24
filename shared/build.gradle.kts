import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.lang.System.getProperty

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
    kotlin("plugin.serialization")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

kotlin {
    android {
        publishLibraryVariantsGroupedByFlavor = true
    }

    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.compilations {
            // todo: it.kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
        }
        it.binaries.framework {
            baseName = "shared"
            isStatic = false
            transitiveExport = true
            xcf.add(this)
        }
    }

    multiplatformSwiftPackage {
        buildConfiguration {
            when (val config = getProperty("BUILD_CONFIGURATION", "debug")) {
                "debug" -> debug()
                "release" -> release()
                else -> named(config)
            }
        }
        packageName("SharedmoduleKmmLibs")
        swiftToolsVersion("5.4")
        targetPlatforms {
            iOS { v("13") }
        }
        outputDirectory(File(rootDir, "/"))
    }

    val ktorVersion by System.getProperties()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.insert-koin:koin-core:3.2.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {

            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }

    packagingOptions {
        resources.excludes.add("META-INF/kotlinx-io.kotlin_module")
        resources.excludes.add("META-INF/atomicfu.kotlin_module")
        resources.excludes.add("META-INF/kotlinx-coroutines-io.kotlin_module")
        resources.excludes.add("META-INF/kotlinx-coroutines-core.kotlin_module")
    }

    buildTypes {
        debug {

        }
        release {

        }
    }
}

publishing {
    repositories {
        maven {
        }
    }
}