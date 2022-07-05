buildscript {
  dependencies {
    classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
  }
}

plugins {
  id("com.android.application") version "7.2.1" apply false
  id("com.android.library") version "7.2.1" apply false
  kotlin("android") version "1.6.21" apply false
}

task("clean", Delete::class) {
  delete(rootProject.buildDir)
}