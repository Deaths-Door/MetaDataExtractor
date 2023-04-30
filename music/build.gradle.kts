plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}

object Metadata {
    val module = "music"
    val version = "0.1.1"
    val description = "MetaDataExtractor is a cross-platform tool for extracting metadata from files, supporting desktop, iOS, Android, and web (JS). It's open-source and user-friendly."
    val repository = "https://github.com/Deaths-Door/MetaDataExtractor"
}

kotlin {
    android {
        publishLibraryVariants("release")
    }

    jvm("desktop")

    js(IR) {
        browser()
        nodejs()
    }
    
    ios()

    cocoapods {
        summary = Metadata.description
        homepage = Metadata.repository
        version = Metadata.version
        ios.deploymentTarget = "14.1"
        framework {
            baseName = Metadata.module
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":base"))
            }
        }
        val commonTest by getting

        val androidMain by getting {
            dependencies {
                implementation("net.jthink:jaudiotagger:3.0.0")
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation("net.jthink:jaudiotagger:3.0.0")
            }
        }

        val desktopTest by getting

        val jsMain by getting{
            dependencies {
                implementation(npm("music-metadata-browser","2.5.10"))
            }
        }
        val jsTest by getting
    }
}

android {
    namespace = "com.deathsdoor.music"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}
