package setting

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        if (project.findProperty("enableComposeCompilerReports") == "true") {
            freeCompilerArgs =
                listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                        project.layout.buildDirectory.get().asFile.absolutePath +
                        "/compose_metrics",
                )
            freeCompilerArgs =
                listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                        project.layout.buildDirectory.get().asFile.absolutePath +
                        "/compose_metrics",
                )
        }
    }
}
