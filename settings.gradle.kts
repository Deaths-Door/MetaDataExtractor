pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        kotlin("android").version(extra["kotlin.version"] as String)
        id("com.android.application").version(extra["agp.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
    }
}
include(":app")
include(":music")
include(":base")