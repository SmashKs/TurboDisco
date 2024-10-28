package config

object AndroidConfiguration {
    const val MIN_SDK = 26
    const val TARGET_SDK = 35
    const val COMPILE_SDK = TARGET_SDK
    const val RELEASE_VERSION = 1
    const val FEATURE_VERSION = 0
    const val VERSION_CODE = 1
    const val VERSION_NAME = "$RELEASE_VERSION.$FEATURE_VERSION.$VERSION_CODE"

    const val ID = "taiwan.no.one.turbodisco"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}
