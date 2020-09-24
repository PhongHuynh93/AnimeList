plugins {
    id(Plugins.androidApplication)
    id(Plugins.hilt)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExtensions)
    kotlin(Plugins.kapt)
}

android {
    compileSdkVersion(Configs.compileSdk)

    defaultConfig {
        applicationId = Configs.applicationId
        minSdkVersion(Configs.minSdk)
        targetSdkVersion(Configs.targetSdk)
        versionCode = Configs.versionCode
        versionName = Configs.versionName
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // module
    implementation(project(":domain"))
    implementation(project(":model"))

    // test
    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.runner)
    androidTestImplementation(Libs.Test.espresso)

    // core
    implementation(Libs.Android.appCompat)
    implementation(Libs.Android.material)
    implementation(Libs.Android.recyclerView)
    implementation(Libs.Android.constraint)
    implementation(Libs.Android.core)
    implementation(Libs.Android.fragment)
    implementation(Libs.Android.lifeCycle)
    implementation(Libs.Android.liveData)
    implementation(Libs.Android.viewModel)

    // paging
    implementation(Libs.Android.page)

    // kotlin
    implementation(Libs.Kotlin.std)

    // For dagger 2
    implementation(Libs.Dagger.core)
    kapt(Libs.Dagger.compiler)
    implementation(Libs.Dagger.viewmodel)
    kapt(Libs.Dagger.hiltCompiler)
    implementation(Libs.Dagger.workmanager)

    // glide
    implementation(Libs.Glide.glide1)
    kapt(Libs.Glide.glide2)
    implementation(Libs.Glide.glideTransform)

    // helper class
    implementation(Libs.Helper.timber)

    // thread
    implementation(Libs.Thread.coroutine)
    implementation(Libs.Thread.coroutineAndroid)
}
