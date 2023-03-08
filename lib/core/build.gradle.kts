android {
    namespace = "taiwan.no.one.core"
}

dependencies {
    api(project(":lib:persist"))
    api(project(":lib:network"))

    implementation(libs.core.ktx)

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
