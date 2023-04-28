plugins {
    kotlin("multiplatform")
  //  kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}

val description = "MetaDataExtractor is a cross-platform tool for extracting metadata from files, supporting desktop, iOS, Android, and web (JS). It's open-source and user-friendly."
val currentVersion = "0.1.0"
val moduleName = "music"

publishing {
    val repoName = "MetaDataExtractor"
    val groupName = "com.deathsdoor.metaDataExtractor"
    val repoURL = "https://github.com/Deaths-Door/MetaDataExtractor"
    repositories {
        maven {
            url = uri(repoURL)
            name = repoName
            group = groupName
            version = currentVersion
        }
    }
    publications {
        register("maven", MavenPublication::class) {
            //  from(components["common"])
            groupId = groupName
            artifactId = moduleName
            version = currentVersion
            pom {
                name.set(repoName)
                description.set(description)
                url.set(repoURL)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }
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

   /* cocoapods {
        summary = description
        homepage = "Link to the Shared Module homepage"
        version = currentVersion
        ios.deploymentTarget = "14.1"
        framework {
            baseName = moduleName
        }
    }*/
    
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

     /*   val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }*/
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
