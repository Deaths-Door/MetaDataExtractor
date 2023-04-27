plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false version "7.2.2"
    id("com.android.library") apply false version "7.2.2"
}

subprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}