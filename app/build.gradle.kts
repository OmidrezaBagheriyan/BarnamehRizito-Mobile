plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.omidrezabagheriyan.barnamehrizitomobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.omidrezabagheriyan.barnamehrizitomobile"
        minSdk = 23
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Base dependencies
    val coreVersion = "1.12.0"
    implementation("androidx.core:core-ktx:$coreVersion")
    val appCompatVersion = "1.6.1"
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    val materialVersion = "1.11.0"
    implementation("com.google.android.material:material:$materialVersion")
    val constraintLayoutVersion = "2.1.4"
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    val junitVersion = "4.13.2"
    testImplementation("junit:junit:$junitVersion")
    val extJunitVersion = "1.1.5"
    androidTestImplementation("androidx.test.ext:junit:$extJunitVersion")
    val espressoVersion = "3.5.1"
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}