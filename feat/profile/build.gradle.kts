plugins {
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "taiwan.no.one.profile"
}

dependencies {
    implementation(libs.core.ktx)

    //region Jetpack Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    implementation(libs.navigation.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.runtime.livedata)
    implementation(libs.coil.compose)

    implementation(libs.accompanist.permissions)

    debugImplementation(libs.debug.ui.tooling)
    //endregion

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
