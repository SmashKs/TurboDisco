import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

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
