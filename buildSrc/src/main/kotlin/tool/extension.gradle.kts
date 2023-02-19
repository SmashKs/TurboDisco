val tomlDependencies = org.jetbrains.kotlin.konan.properties.loadProperties(
    projectDir.resolve("../gradle/libs.versions.toml").toString(),
)
