plugins {
    `kotlin-dsl`
}

// gradle versions above 4.10.
repositories {
    // The org.jetbrains.kotlin.jvm plugin requires a repository
    // where to download the Kotlin compiler dependencies from.
    google()
    mavenCentral()
    gradlePluginPortal()
}

val tomlDependencies = org.jetbrains.kotlin.konan.properties.loadProperties(
    projectDir.resolve("../gradle/libs.versions.toml").toString(),
)

dependencies {
    fun refVerCompileOnly(artifact: String, refVerNotation: String) {
        val version = tomlDependencies[refVerNotation].toString().replace("\"", "")
        compileOnly("$artifact:$version")
    }

    refVerCompileOnly("com.android.tools.build:gradle", "gradle")
    refVerCompileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin", "kotlin")
}
