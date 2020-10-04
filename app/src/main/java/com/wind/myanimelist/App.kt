package com.wind.myanimelist

import android.app.Application
import com.wind.data.di.dataModule
import com.wind.myanimelist.di.appModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

/**
 * Created by Phong Huynh on 9/26/2020
 */
class App: Application(), DIAware {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override val di = DI {
        import(androidXModule(this@App))
        import(appModule)
    }
}