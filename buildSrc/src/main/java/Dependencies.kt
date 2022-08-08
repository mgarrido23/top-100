object Versions {
    // Build Config
    const val minSDK = 21
    const val compileSDK = 31
    const val targetSDK = 31
    const val buildTools = "30.0.2"

    // App version
    const val appVersionCode = 1
    const val appVersionName = "0.0.1"

    // Plugins
    const val androidGradlePlugin = "7.0.3"

    // Kotlin
    const val kotlin = "1.6.21"

    // Ktlint
    const val ktlint = "0.42.1"

    // Testing
    const val junit = "4.13.2"
    const val junitX = "1.1.3"
    const val espresso = "3.4.0"
    const val runner = "1.1.0"

    // AndroidX
    const val androidExt = "1.7.0"
    const val compose = "1.2.0-beta02"
    const val activity = "1.4.0"

    // Jetpack
    const val navigation = "2.4.2"
    const val lifecycle = "2.4.1"
    const val viewModelLifecycle = "2.4.0-rc01"
    const val realm = "10.7.0"
    const val realmKotlin = "1.0.1"

    // Network
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val moshi = "1.9.3"

    // Dependency Injection
    const val hilt = "2.38.1"
    const val hiltNavigationCompose = "1.0.0-alpha03"

    // Concurrency
    const val coroutines = "1.5.2"

    // Memory Leaks
    const val leakCanary = "2.7"

    // Other
    const val coil = "2.1.0"
}

object Deps {
    // Plugins
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    // Ktlint
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitX = "androidx.test.ext:junit:${Versions.junitX}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.runner}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    // AndroidX
    const val androidExt = "androidx.core:core-ktx:${Versions.androidExt}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeUiPreviewTools = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeUiTools = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activity}"

    // Jetpack Navigation
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Jetpack Lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelLifecycle}"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // DB
    const val realm = "io.realm:realm-gradle-plugin:${Versions.realm}"
    const val realmKotlin = "io.realm.kotlin:library-base:${Versions.realmKotlin}"

    // Dependency Injection
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCore = "com.google.dagger:hilt-core:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"

    // Concurrency
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Memory Leaks
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    // Other
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}
