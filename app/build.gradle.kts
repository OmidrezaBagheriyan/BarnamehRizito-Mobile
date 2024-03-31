plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("com.google.dagger.hilt.android")
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
    //DataStore dependency
    val dataStoreVersion = "1.0.0"
    implementation("androidx.datastore:datastore-preferences:$dataStoreVersion")

    //Activity dependency + Fragment dependency
    val activityVersion = "1.8.2"
    implementation("androidx.activity:activity-ktx:$activityVersion")
    val fragmentVersion = "1.6.2"
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    val legacyVersion = "1.0.0"
    implementation("androidx.legacy:legacy-support-v4:$legacyVersion")
    val recyclerviewVersion = "1.3.2"
    implementation("androidx.recyclerview:recyclerview:$recyclerviewVersion")

    // Lifecycle dependency
    val lifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    // Kotlin-Coroutines dependency
    val coroutinesVersion = "1.7.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    //Lottie components
    val lottieVersion = "5.2.0"
    implementation("com.airbnb.android:lottie:$lottieVersion")

    // Room dependency
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")

    // Navigation dependency
    val navVersion = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Hilt dependency
    val hiltVersion = "2.51.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

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

kapt {
    correctErrorTypes = true
}