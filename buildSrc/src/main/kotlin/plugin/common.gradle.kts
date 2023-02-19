package plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.DynamicFeatureExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension

fun BaseExtension.applyCompileOptions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

fun BaseExtension.applyTestOptions() {
    testOptions {
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }
}

fun DynamicFeatureExtension.applyLintOptions() {
    lint {
        abortOnError = false
        ignoreWarnings = true
        quiet = true
    }
}

fun ApplicationExtension.applyLintOptions() {
    lint {
        abortOnError = false
        ignoreWarnings = true
        quiet = true
    }
}

fun LibraryExtension.applyLintOptions() {
    lint {
        abortOnError = false
        ignoreWarnings = true
        quiet = true
    }
}
