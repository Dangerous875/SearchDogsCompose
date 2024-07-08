plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("org.jetbrains.kotlinx.kover")

}

android {
    namespace = "com.example.dogsearchcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dogsearchcompose"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val navVersion = "2.7.7"
    val retrofitVersion = "2.9.0"
    val navigationCompose = "1.2.0"
    val hilt = "2.51.1"
    val coilCompose = "2.4.0"
    val composeRuntime = "1.6.8"
    val viewModel = "2.8.3"

// Navigation
    implementation ("androidx.navigation:navigation-compose:$navVersion")
// Hilt & Dagger
    implementation ("com.google.dagger:hilt-android:$hilt")
    implementation ("androidx.hilt:hilt-navigation-compose:$navigationCompose")
    kapt("com.google.dagger:hilt-compiler:$hilt")
// Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
// Coil
    implementation ("io.coil-kt:coil-compose:$coilCompose")
    implementation ("androidx.compose.runtime:runtime:$composeRuntime")
// ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModel")
// life
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}