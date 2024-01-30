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

val catalog = extensions.getByType<VersionCatalogsExtension>()

dependencies {
    fun refVerImplementation(artifact: String, refVerNotation: String) {
        val version = tomlDependencies[refVerNotation].toString().replace("\"", "")
        implementation("$artifact:$version")
    }

    refVerImplementation("com.android.tools.build:gradle", "gradle")
    refVerImplementation("org.jetbrains.kotlin:kotlin-gradle-plugin", "kotlin")
    refVerImplementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin", "detekt-gradle-plugin")
}
