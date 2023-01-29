buildscript {
    dependencies {
//        classpath libs.google.services
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("8.1.0-alpha02").apply(false)
    id("com.android.library").version("8.1.0-alpha02").apply(false)
    id("org.jetbrains.kotlin.android").apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.google.gms.google.services)
    alias(libs.plugins.com.google.devtools.ksp)
}
