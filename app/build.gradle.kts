plugins {
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.jraska.module.graph.assertion")
}

android {
    namespace = "taiwan.no.one.turbodisco"

    defaultConfig {
        applicationId = "taiwan.no.one.turbodisco"
        versionCode = 1
        versionName = "1.0"
    }

    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }
}

dependencies {
    implementation(project(":lib:core"))

    implementation(libs.core.ktx)
    //region Jetpack Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.activity.compose)
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.runtime.livedata)
    implementation(libs.coil.compose)

    implementation(libs.accompanist.permissions)

    debugImplementation(libs.debug.ui.tooling)
    //endregion

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.startup.runtime)
    implementation(libs.work.runtime.ktx)

    api(platform(libs.firebase.bom))
    api(libs.firebase.message.ktx)

    //region di koin
    implementation(libs.koin.androidx.workmanager)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)
    //endregion

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

moduleGraphAssert {
    maxHeight = 2
    allowed = arrayOf(":.* -> :lib:core", ":lib.* -> :lib.*")
    restricted = arrayOf("[\\S:]*-api -X> [\\S:]*-api")
    configurations = setOf("api", "implementation")
    assertOnAnyBuild = true
}

apply { plugin("com.google.gms.google-services") }
