plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 32

  defaultConfig {
    applicationId = "com.example.calendar"
    minSdk = 23
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables.useSupportLibrary = true
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("debug")
    }
  }
  compileOptions {
    isCoreLibraryDesugaringEnabled = true
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.compose
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

  implementation("androidx.core:core-ktx:1.8.0")
  implementation("androidx.compose.ui:ui:${Versions.compose}")
  implementation("androidx.compose.material:material:${Versions.compose}")
  implementation("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
  implementation("androidx.activity:activity-compose:1.4.0")

  implementation("androidx.navigation:navigation-compose:2.4.2")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

  implementation("com.google.dagger:hilt-android:${Versions.hilt}")
  kapt("com.google.dagger:hilt-compiler:${Versions.hilt}")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")

  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}")
  implementation("androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}")

  implementation("androidx.room:room-ktx:${Versions.room}")
  implementation("androidx.room:room-runtime:${Versions.room}")
  kapt("androidx.room:room-compiler:${Versions.room}")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose}")
  debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
  debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.compose}")
}