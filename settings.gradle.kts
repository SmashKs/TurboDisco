pluginManagement {
    repositories {
        gradlePluginPortal()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
    plugins {
        fun getVersion(libName: String): String = File("$rootDir/gradle/libs.versions.toml")
            .readLines()
            .first { it.contains("$libName =") }
            .split("\"")[1]

        id("com.android.application") version getVersion("gradle") apply false
        id("com.android.library") version getVersion("gradle") apply false
        id("org.jetbrains.kotlin.android") version getVersion("kotlin") apply false
        id("de.fayard.refreshVersions") version "0.60.5"
        id("com.jraska.module.graph.assertion") version "2.3.1"
    }
}

plugins {
    id("de.fayard.refreshVersions")
}

dependencyResolutionManagement {
//    versionCatalogs {
//        create("libs") {
//            from(files("gradle/libs.versions.toml"))
//        }
//    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral() // XXX(jieyi): 2023/04/04 This is for the dev jetpack compose repo
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
include(":feat:favorite")
include(":feat:photo")
include(":feat:search")
include(":lib:analytic")
include(":lib:ktx")
include(":lib:core")
include(":lib:ds")
include(":lib:ext")
include(":lib:persist")
include(":lib:network")
