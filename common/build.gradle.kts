plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {

    // Kotlin
    implementation(Deps.kotlinStdLib)

    // Dependency Injection
    implementation(Deps.hiltCore)
    kapt(Deps.hiltCompiler)

    // Concurrency
    implementation(Deps.coroutines)

    // Network
    implementation(Deps.retrofit)
}
