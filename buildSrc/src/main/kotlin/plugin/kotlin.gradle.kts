package plugin

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

subprojects {
    tasks.withType<KotlinCompile> {
        println("=================================================")
        println("?????????????????????")
        println("=================================================")
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
            suppressWarnings = false
            languageVersion = "1.9"
            freeCompilerArgs = listOf("-Xcontext-receivers")
        }
    }
}
