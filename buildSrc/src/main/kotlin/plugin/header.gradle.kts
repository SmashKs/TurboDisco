package plugin

subprojects {
    beforeEvaluate {
        apply {
            project.toString().apply project@{
                if (split(":").size == 2 && !contains("app")) return@project
                if (contains(":lib:ext")) {
                    plugin("java-library")
                    plugin("kotlin")
                } else {
                    if (contains(":app")) {
                        plugin("com.android.application")
                    } else {
                        plugin("com.android.library")
                    }
                    plugin("kotlin-android")
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
