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
    implementation(project(":data"))
    implementation(project(":model"))

    implementation(Libs.Kotlin.std)

    // dagger
    implementation(Libs.Dagger.coreDagger)
    kapt(Libs.Dagger.compilerDagger)
    implementation(Libs.Dagger.core)
    kapt(Libs.Dagger.compiler)

    // thread
    implementation(Libs.Thread.coroutine)

    // helper
    implementation(Libs.Helper.timber)
    implementation(Libs.Helper.workManager)

    // paging
    implementation(Libs.Android.page)
}