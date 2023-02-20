plugins {
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "taiwan.no.one.turbodisco"
    compileSdk = 33

    defaultConfig {
        applicationId = "taiwan.no.one.turbodisco"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
        suppressWarnings = false
        languageVersion = "1.9"
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
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

    implementation(libs.datastore.preferences)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    //region Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.logging)
    //endregion

    //region di koin
    implementation(libs.koin.androidx.workmanager)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)
    //endregion

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
