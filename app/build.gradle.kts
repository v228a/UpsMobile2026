import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}



android {
    namespace = "com.vovka.upsmobile"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.vovka.upsmobile"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        val mapkitApiKey = rootProject.extra["mapkitApiKey"] as String
        buildConfigField("String", "MAPKIT_API_KEY", "\"$mapkitApiKey\"")


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        buildConfig =  true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("com.yandex.android:maps.mobile:4.22.0-lite")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}