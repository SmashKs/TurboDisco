package plugin

val ktlint by configurations.creating

dependencies {
    val tomlDependencies = org.jetbrains.kotlin.konan.properties.loadProperties(
        rootDir.resolve("gradle/libs.versions.toml").toString(),
    )
    val version = tomlDependencies["ktlint"].toString().replace("\"", "")
    ktlint("com.pinterest:ktlint:$version")
}

tasks {
    register<JavaExec>("ktlint") {
        group = "verification"
        description = "Check Kotlin code style."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args("--android", "src/**/*.kt")
    }

    register<JavaExec>("ktlintFormat") {
        group = "verification"
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args("--android", "-F", "src/**/*.kt")
    }
}
