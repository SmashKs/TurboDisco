package plugin

fun Project.applyPluginFromAlias(alias: String) {
    val pluginId =
        project.extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs")
            .findPlugin(alias)
            .get()
            .get()
            .pluginId
    apply(plugin = pluginId)
}

subprojects {
    beforeEvaluate {
        apply {
            project.toString().apply project@{
                val moduleStrings = split(":")
                if (moduleStrings.size == 2 && !contains("app")) return@project
                if (contains(":lib:ext")) {
                    plugin("java-library")
                    plugin("kotlin")
                } else {
                    if (contains(":app")) {
                        plugin("com.android.application")
                        plugin("kotlin-parcelize")
                    } else {
                        plugin("com.android.library")
                    }
                    plugin("kotlin-android")
                    if ("feat" in moduleStrings) {
                        plugin("kotlin-parcelize")
                    }
                }
//                in modules -> {
//                    // special plugins
//                    if (name in listOf("entity", "core")) {
//                        plugin("com.google.devtools.ksp")
//                    }
//                    if (name in listOf("entity")) {
//                        plugin("kotlin-parcelize")
//                    }
//                }
//                in features -> {
//                    plugin("kotlin-parcelize")
//                    plugin("com.google.devtools.ksp")
//                }
            }
        }
    }
}
