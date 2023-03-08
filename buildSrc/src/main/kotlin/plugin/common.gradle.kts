package plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import config.AndroidConfiguration

subprojects {
    afterEvaluate {
        //region Common Setting
        if (name !in listOf("ext", "feat", "lib")) {
            // BaseExtension is common parent for application, library and test modules
            extensions.apply {
                configure<BaseExtension> {
                    compileSdkVersion(AndroidConfiguration.COMPILE_SDK)
                    defaultConfig {
                        minSdk = AndroidConfiguration.MIN_SDK
                        targetSdk = AndroidConfiguration.TARGET_SDK
                        vectorDrawables.useSupportLibrary = true
                        testInstrumentationRunner = AndroidConfiguration.TEST_INSTRUMENTATION_RUNNER
                        consumerProguardFiles(file("consumer-rules.pro"))
                    }
                    buildTypes {
                        getByName("release") {
                            // This is exceptions.
                            if (this@subprojects.name == "app") {
                                // isMinifyEnabled = true
                                proguardFiles(
                                    getDefaultProguardFile("proguard-android-optimize.txt"),
                                    file("proguard-rules.pro"),
                                )
                            }
                        }
                        getByName("debug") {
                            splits.abi.isEnable = false
                            splits.density.isEnable = false
                            aaptOptions.cruncherEnabled = false
                            // XXX(jieyi): Don't know the reason why if [isTestCoverageEnabled] removed, the jacoco
                            //  report is generated.
                            //  ref: [https://stackoverflow.com/questions/70589854/android-jacoco-code-coverage-is-not-generating-after-gradle-upgrade-to-7-0-x]
                            //  ref: [https://stackoverflow.com/questions/67299155/kotlin-jacoco-illegalclassformatexception-please-supply-original-non-instrume]
                            // isTestCoverageEnabled = true
                            // Only use this flag on builds you don't proguard or upload to beta-by-crashlytics.
                            // ext.set("alwaysUpdateBuildId", false)
                            isCrunchPngs = false // Enabled by default for RELEASE build type
                        }
                    }
                    applyCompileOptions()
                    applyTestOptions()
                }
                // For the different type of the project.
                findByType(ApplicationExtension::class.java)?.applyLintOptions()
                findByType(LibraryExtension::class.java)?.applyLintOptions()
                // For Jetpack Compose
                if (!(name == "app" || displayName.contains(":feat:"))) return@apply
                (findByType(CommonExtension::class.java) as? CommonExtension<BuildFeatures, *, *, *>)?.applyCompose()
            }
        }
        //endregion
    }
}

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

fun CommonExtension<BuildFeatures, *, *, *>.applyCompose() {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}
