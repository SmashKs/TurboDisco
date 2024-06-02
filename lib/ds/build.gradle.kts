plugins {
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "taiwan.no.one.ds"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.fundation)
    implementation(libs.ui.tooling.preview)

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
