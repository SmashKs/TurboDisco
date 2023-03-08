plugins {
    id("com.google.devtools.ksp")
}

android {
    namespace = "taiwan.no1.network"
}

dependencies {
    api(libs.ktor.client.core)
    api(libs.ktor.client.okhttp)
    api(libs.ktor.client.android)
    api(libs.ktor.client.logging)
    api(libs.ktor.client.serialization)
    api(libs.ktor.client.content.negotiation)

    implementation(libs.koin.core)
    implementation(libs.koin.android)

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
