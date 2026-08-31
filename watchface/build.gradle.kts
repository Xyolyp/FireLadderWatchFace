plugins {
    id("com.android.application")
}

android {
    namespace = "de.example.fireladderwatchface"
    compileSdk = 35

    defaultConfig {
        applicationId = "de.example.fireladderwatchface"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = false
        }
    }
}
