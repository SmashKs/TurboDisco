package plugin

// import BuildTaskGroups
//
// val ktlint by configurations.creating
//
// dependencies {
//    ktlint("com.pinterest:ktlint:0.43.2")
// }
//
// tasks {
//    register<JavaExec>("ktlint") {
//        group = BuildTaskGroups.VERIFICATION
//        description = "Check Kotlin code style."
//        classpath = ktlint
//        mainClass.set("com.pinterest.ktlint.Main")
//        args("--android", "src/**/*.kt")
//    }
//
//    register<JavaExec>("ktlintFormat") {
//        group = BuildTaskGroups.VERIFICATION
//        description = "Fix Kotlin code style deviations."
//        classpath = ktlint
//        mainClass.set("com.pinterest.ktlint.Main")
//        args("--android", "-F", "src/**/*.kt")
//    }
// }
