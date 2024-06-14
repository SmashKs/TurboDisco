package plugin

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

subprojects {
    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            languageVersion.set(KotlinVersion.KOTLIN_2_0)
            freeCompilerArgs.set(
                listOf(
                    "-Xcontext-receivers",
                    "-XXLanguage:+ExplicitBackingFields",
                ),
            )
        }
    }
}
