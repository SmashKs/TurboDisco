android {
    namespace = "taiwan.no.one.core"
}

dependencies {
    implementation(libs.core.ktx)

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
