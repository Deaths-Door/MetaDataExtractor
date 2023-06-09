plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    js(IR) {
        browser()
        binaries.executable()
    }
    
    ios()

    cocoapods {
        summary = "Base module for https://github.com/Deaths-Door/MetaDataExtractor github library"
        version = "0.1.2"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "base"
        }
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting

        val androidMain by getting

        val jvmMain by getting
        val jvmTest by getting

        val jsMain by getting
        val jsTest by getting
    }
}

android {
    namespace =  "com.deathsdoor.metadataextractor.base"
    compileSdk = 33

    defaultConfig.minSdk = 21
    defaultConfig.targetSdk = 33

    compileOptions.sourceCompatibility = JavaVersion.VERSION_11
    compileOptions.targetCompatibility = JavaVersion.VERSION_11
}
