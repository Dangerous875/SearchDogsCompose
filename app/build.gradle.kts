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
    val hiltVersion = "2.49"
    val retrofitVersion = "2.9.0"
    val navigationCompose = "1.2.0"
    val hilt = "2.49"
    val coilCompose = "2.4.0"
    val composeRuntime = "1.6.5"
    val viewModel = "2.7.0"

// Navigation
    implementation ("androidx.navigation:navigation-compose:$navVersion")
// Hilt & Dagger
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
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
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.5")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}