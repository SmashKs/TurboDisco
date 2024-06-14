// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // because those are defined in header.gradle.kts :(
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.kotlin.android).apply(false)
//    alias(libs.plugins.jetbrains.kotlin.android) apply false
//    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.jetbrains.kotlin.serialization) apply false
    alias(libs.plugins.com.google.gms.google.services) apply false
    alias(libs.plugins.com.google.devtools.ksp) apply false
    alias(libs.plugins.compose.compiler) apply false
}

plugins.apply("plugin.header")
plugins.apply("plugin.common")
plugins.apply("plugin.detekt")
plugins.apply("plugin.kotlin")

subprojects {
    beforeEvaluate {
        if (name in listOf("ext", "test", "feat", "lib")) return@beforeEvaluate
        plugins.apply("plugin.jacoco")
    }
}

allprojects {
    plugins.apply("plugin.ktlint")
}
