package plugin

import java.io.FileInputStream
import org.jetbrains.kotlin.konan.properties.Properties

subprojects {
    beforeEvaluate {
        apply {
            val prop = Properties().apply {
                load(FileInputStream(File(rootProject.rootDir, "settings.gradle.kts")))
            }
//            println("=================================================")
//            println(prop)
//            println("=================================================")
//            when (name) {
//                in listOf("ext") -> {
//                    plugin("java-library")
//                    plugin("kotlin")
//                }
//                in modules -> {
//                    plugin("com.android.library")
//                    plugin("kotlin-android")
//                    // special plugins
//                    if (name in listOf("entity", "core")) {
//                        plugin("com.google.devtools.ksp")
//                    }
//                    if (name in listOf("entity")) {
//                        plugin("kotlin-parcelize")
//                    }
//                }
//                in features -> {
//                    plugin("com.android.dynamic-feature")
//                    plugin("kotlin-android")
//                    plugin("kotlin-parcelize")
//                    plugin("com.google.devtools.ksp")
//                    plugin("androidx.navigation.safeargs.kotlin")
//                }
//            }
        }
    }
}
