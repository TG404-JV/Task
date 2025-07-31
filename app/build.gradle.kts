plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")

}

android {
    namespace = "com.tg.societymanagment"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.tg.societymanagment"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    viewBinding {
        enable = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("np.com.susanthapa:curved_bottom_navigation:0.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")
// LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.2")
// Lifecycle-runtime (helps with lifecycle awareness in coroutines etc.)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")
    // Room
    implementation ("androidx.room:room-runtime:2.7.2")
    implementation ("androidx.room:room-ktx:2.7.2")

// Use KSP instead of kapt!
    kapt ("androidx.room:room-compiler:2.7.2")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("com.google.code.gson:gson:2.10.1")

}