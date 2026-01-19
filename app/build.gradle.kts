plugins {
    alias(libs.plugins.pluginid.android.application)
    alias(libs.plugins.pluginid.kotlin.compose)
    alias(libs.plugins.pluginid.kotlin.parcelize)
    alias(libs.plugins.pluginid.com.google.devtools.ksp)
    alias(libs.plugins.pluginid.com.google.dagger.hilt.android)
    alias(libs.plugins.pluginid.kotlin.android)
}

android {
    namespace = "com.zhuinden.catexample2026jan"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.zhuinden.catexample2026jan"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }
}



dependencies {
    implementation(libs.libraryid.androidx.core.ktx)
    implementation(libs.libraryid.androidx.lifecycle.runtime.ktx)
    implementation(libs.libraryid.androidx.activity.compose)
    implementation(platform(libs.libraryid.androidx.compose.bom))
    implementation(libs.libraryid.androidx.compose.ui)
    implementation(libs.libraryid.androidx.compose.ui.graphics)
    implementation(libs.libraryid.androidx.compose.ui.tooling.preview)
    implementation(libs.libraryid.androidx.compose.material3)
    implementation(libs.libraryid.androidx.compose.material3.adaptive.navigation.suite)
    implementation(libs.libraryid.androidx.compose.material.icons.extended)

    implementation(libs.libraryid.squareup.retrofit2.retrofit)
    implementation(libs.libraryid.squareup.retrofit2.converter.gson)

    implementation(libs.libraryid.com.zhuinden.flow.combinetuple.kt)

    implementation(libs.libraryid.dagger)
    implementation(libs.libraryid.dagger.hilt.android)

    ksp(libs.libraryid.dagger.compiler)
    ksp(libs.libraryid.androidx.hilt.compiler)
    ksp(libs.libraryid.dagger.hilt.android.compiler)

    implementation(libs.libraryid.androidx.hilt.navigation.compose)
    // implementation(libs.libraryid.androidx.hilt.work) // Targeting S+ (version 31 and above) requires that one of FLAG_IMMUTABLE or FLAG_MUTABLE
    implementation(libs.libraryid.androidx.hilt.lifecycle.viewmodel)
    implementation(libs.libraryid.androidx.hilt.lifecycle.viewmodel.compose)
    implementation(libs.libraryid.androidx.hilt.navigation)
    implementation(libs.libraryid.androidx.hilt.navigation.fragment)
    implementation(libs.libraryid.androidx.hilt.common)

    implementation(libs.libraryid.coil.compose)
    implementation(libs.libraryid.coil.network.okhttp)

    testImplementation(libs.libraryid.junit)
    androidTestImplementation(libs.libraryid.androidx.test.ext)
    androidTestImplementation(libs.libraryid.androidx.espresso.core)
    androidTestImplementation(platform(libs.libraryid.androidx.compose.bom))
    androidTestImplementation(libs.libraryid.androidx.compose.ui.test.junit4)
    debugImplementation(libs.libraryid.androidx.compose.ui.tooling)
    debugImplementation(libs.libraryid.androidx.compose.ui.test.manifest)
}