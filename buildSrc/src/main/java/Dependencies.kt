object Versions {
    const val kotlin = "1.4.0"
    const val kotlinCoroutines = "1.3.9"
    const val gradlePlugin: String = "4.0.1"
    const val glide: String = "4.10.0"
    const val supportLibrary: String = "1.1.0"
    const val material: String = "1.3.0-alpha02"
    const val constraintLayout: String = "2.0.0"
    const val room: String = "2.2.2"
    const val ktor = "1.4.0"
}

object Libs {
    object Android {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha02"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val viewPager = "androidx.viewpager2:viewpager2:1.0.0"
        const val page = "androidx.paging:paging-runtime-ktx:3.0.0-alpha06"
        const val core = "androidx.core:core-ktx:1.3.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.0-alpha08"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    }
    object Kotlin {
        const val std = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }
    object Dagger {
        const val core = "org.kodein.di:kodein-di-framework-android-x:7.1.0"
    }
    object Test {
        const val junit = "junit:junit:4.12"
        const val runner = "com.android.support.test:runner:1.0.2"
        const val espresso = "com.android.support.test.espresso:espresso-core:3.0.2"
    }
    object Glide {
        const val glide1 = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glide2 = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val glideTransform = "jp.wasabeef:glide-transformations:4.0.0"
    }
    object Helper {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val lottie = "com.airbnb.android:lottie:3.0.1"
        const val multidex = "androidx.multidex:multidex:2.0.1"
        const val playCore = "com.google.android.play:core:1.6.4"
//        const val firebase = "com.google.firebase:firebase-analytics:17.4.3"
//        const val crashLytic = "com.google.firebase:firebase-crashlytics:17.1.0"
        const val skeleton = "io.supercharge:shimmerlayout:2.1.0"
        const val workManager = "androidx.work:work-runtime-ktx:2.4.0"
    }
    object Thread {
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions
            .kotlinCoroutines}"
    }
    object Db {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomRx2 = "androidx.room:room-ktx:${Versions.room}"
    }
    object Ad {
        const val adMob = "com.google.android.gms:play-services-ads:19.2.0"
    }
    object Network {
        const val network1 = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val network2 = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val network3 = "io.ktor:ktor-client-serialization-jvm:${Versions.ktor}"
        const val log = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
        const val log2 = "ch.qos.logback:logback-classic:1.2.3"
        const val parser = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2"
    }
}

object Configs {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = 29

    const val applicationId = "com.wind.myanimelist"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "android"
    const val kotlinExtensions = "android.extensions"
//    const val googleService = "com.google.gms.google-services"
//    const val crashlytics = "com.google.firebase.crashlytics"
    const val kapt = "kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val serialization = "kotlinx-serialization"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleServices = "com.google.gms:google-services:4.3.3"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta02"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
}