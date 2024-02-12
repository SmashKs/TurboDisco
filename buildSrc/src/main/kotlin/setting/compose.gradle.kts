package setting

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        if (project.findProperty("enableComposeCompilerReports") == "true") {
            freeCompilerArgs += listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                    project.buildDir.absolutePath +
                    "/compose_metrics",
            )
            freeCompilerArgs += listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                    project.buildDir.absolutePath +
                    "/compose_metrics",
            )
        }
    }
}
