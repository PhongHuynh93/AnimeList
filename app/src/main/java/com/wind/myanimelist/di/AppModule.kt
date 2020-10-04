package com.wind.myanimelist.di

import com.wind.data.di.dataModule
import com.wind.domain.di.domainModule
import org.kodein.di.DI

/**
 * Created by Phong Huynh on 9/30/2020
 */
val appModule = DI.Module("app") {
    import(dataModule)
    import(domainModule)
}