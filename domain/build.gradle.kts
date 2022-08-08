plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Modules
    implementation(project(":common"))

    // Kotlin
    implementation(Deps.kotlinStdLib)

    // Dependency Injection
    implementation(Deps.hiltCore)
    kapt(Deps.hiltCompiler)

    // Concurrency
    implementation(Deps.coroutines)
}
