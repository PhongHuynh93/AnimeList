plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kapt)
}

android {
    compileSdkVersion(Configs.compileSdk)

    defaultConfig {
        minSdkVersion(Configs.minSdk)
        targetSdkVersion(Configs.targetSdk)
        versionCode = Configs.versionCode
        versionName = Configs.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":model"))

    implementation(Libs.Kotlin.std)
    implementation(Libs.Android.core)

    // dagger
    implementation(Libs.Dagger.coreDagger)
    kapt(Libs.Dagger.compilerDagger)
    implementation(Libs.Dagger.core)
    implementation(Libs.Dagger.workmanager)
    kapt(Libs.Dagger.compiler)

    // network
    implementation(Libs.Network.network1)
    implementation(Libs.Network.network2)
    implementation(Libs.Network.network3)
    implementation(Libs.Network.log)
    implementation(Libs.Network.parser)

    // thread
    implementation(Libs.Thread.coroutine)

    // helper
    implementation(Libs.Helper.timber)
    implementation(Libs.Helper.workManager)

    // paging
    implementation(Libs.Android.page)
}