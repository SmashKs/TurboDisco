android {
    namespace = "taiwan.no.one.analytic"
}

dependencies {
    api(platform(libs.firebase.bom))
    api(libs.firebase.analytics.ktx)
    api(libs.sentry.android)

    implementation(libs.core.ktx)

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
