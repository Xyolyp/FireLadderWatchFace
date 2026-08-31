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
        versionCode = (findProperty("ciVersionCode") as String?)?.toIntOrNull() ?: 1
        versionName = "1.0"
    }

    // CI signing: provided via environment (KEYSTORE_FILE + KEYSTORE_PASSWORD).
    val ciKeystore = System.getenv("KEYSTORE_FILE")
    val ciKeystorePassword = System.getenv("KEYSTORE_PASSWORD")
    if (ciKeystore != null && ciKeystorePassword != null) {
        signingConfigs {
            create("ci") {
                storeFile = file(ciKeystore)
                storePassword = ciKeystorePassword
                keyAlias = "fireladder"
                keyPassword = ciKeystorePassword
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = false
            signingConfigs.findByName("ci")?.let { signingConfig = it }
        }
    }
}
