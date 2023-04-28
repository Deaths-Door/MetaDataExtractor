plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
}

subprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}