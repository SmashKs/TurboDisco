pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("de.fayard.refreshVersions").version("0.51.0")
////                                # available:"0.60.0")
////                                # available:"0.60.1")
////                                # available:"0.60.2")
////                                # available:"0.60.3")
        id("com.android.library") version "8.4.0-alpha05"
        id("org.jetbrains.kotlin.android") version "1.9.22"
        id("org.jetbrains.kotlin.jvm") version "1.9.22"
        id("com.jraska.module.graph.assertion") version "2.3.1"
    }
}

plugins {
    id("de.fayard.refreshVersions")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // XXX(jieyi): 2023/04/04 This is for the dev jetpack compose repo
        maven {
            setUrl("https://androidx.dev/storage/compose-compiler/repository/")
        }
    }
}

rootProject.name = "TurboDisco"
include(":app")
include(":feat:review")
include(":feat:profile")
include(":feat:auth")
include(":feat:comment")
include(":feat:sake")
include(":feat:search")
include(":lib:analytic")
include(":lib:ktx")
include(":lib:core")
include(":lib:ext")
include(":lib:persist")
include(":lib:network")
