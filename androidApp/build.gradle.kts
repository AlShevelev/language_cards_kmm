plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AndroidConfigData.compileSdkVersion
    defaultConfig {
        applicationId = "com.shevelev.languagecards.android"
        minSdk = AndroidConfigData.minSdkVersion
        targetSdk = AndroidConfigData.targetSdkVersion
        versionCode = AndroidConfigData.versionCode
        versionName = AndroidConfigData.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(project(":shared"))

    implementation(Dependencies.Android.appCompat)

    implementation(Dependencies.Android.composeUi)
    implementation(Dependencies.Android.composeMaterial)
    implementation(Dependencies.Android.composeUiToolingPreview)
    implementation(Dependencies.Android.lifecycleRuntimeKtx)
    implementation(Dependencies.Android.activityCompose)
    debugImplementation(Dependencies.Android.composeUiTooling)
}