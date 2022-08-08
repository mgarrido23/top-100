import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

// Secrets are stored in a file that is ignored in git for security reasons.
val secretFile = rootProject.file("secret.properties")
val secretProperties = Properties()
secretProperties.load(FileInputStream(secretFile))

android {
    compileSdk = Versions.compileSDK
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = "com.top100.app"
        minSdk = Versions.minSDK
        targetSdk = Versions.targetSDK
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", secretProperties["api.key"] as? String ?: "\"\"")
    }

    signingConfigs {
        create("cds") {
            storeFile = file("../keystores/cds.keystore")
            storePassword = secretProperties["signing.storePassword"] as String
            keyAlias = secretProperties["signing.keyAlias"] as String
            keyPassword = secretProperties["signing.keyPassword"] as String
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("cds")
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("cds")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    lint {
        disable("MissingTranslation")
        isCheckReleaseBuilds = false
        isWarningsAsErrors = true
        baselineFile = file("lint-baseline.xml")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Modules
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common"))

    // Kotlin
    implementation(Deps.kotlinStdLib)

    // AndroidX
    implementation(Deps.androidExt)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composeUiPreviewTools)
    implementation(Deps.composeActivity)

    // Jetpack Navigation
    implementation(Deps.composeNavigation)

    // Jetpack Lifecycle
    implementation(Deps.lifecycle)
    implementation(Deps.viewModelLifecycle)

    // Dependency Injection
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)

    // Concurrency
    implementation(Deps.coroutines)
    implementation(Deps.coroutinesAndroid)

    // Coil
    implementation(Deps.coil)

    //implementation(Deps.swipeRefresh)

    // Memory Leaks
    debugImplementation(Deps.leakCanary)

    // Testing
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitX)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.testRunner)
    androidTestImplementation(Deps.composeUiTest)

    // Debug
    debugImplementation(Deps.composeUiTools)
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}
