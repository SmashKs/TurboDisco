package plugin

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

subprojects {
    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
            suppressWarnings.set(false)
//            languageVersion.set(KotlinVersion.KOTLIN_2_0)
            languageVersion.set(KotlinVersion.KOTLIN_1_9)
            freeCompilerArgs.set(
                listOf(
                    "-Xcontext-receivers",
//                    "-Xuse-k2",
                ),
            )
        }
    }
}
