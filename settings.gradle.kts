pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("de.fayard.refreshVersions").version("0.51.0")
        id("com.android.library") version "8.1.0-alpha05"
        id("org.jetbrains.kotlin.android") version "1.8.0"
        id("org.jetbrains.kotlin.jvm") version "1.8.0"
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
