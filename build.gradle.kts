plugins.apply("plugin.header")
plugins.apply("plugin.common")
plugins.apply("plugin.detekt")
plugins.apply("plugin.kotlin")

buildscript {
    dependencies {
//        classpath libs.google.services
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    alias(libs.plugins.com.android.application).apply(false)
//    alias(libs.plugins.com.android.library).apply(false)
//    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.google.gms.google.services)
    alias(libs.plugins.com.google.devtools.ksp)
    alias(libs.plugins.compose.compiler) apply false
}

subprojects {
    beforeEvaluate {
        if (name in listOf("ext", "test", "feat", "lib")) return@beforeEvaluate
        plugins.apply("plugin.jacoco")
    }
}

allprojects {
    plugins.apply("plugin.ktlint")
}
