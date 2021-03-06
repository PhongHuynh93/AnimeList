package com.wind.myanimelist.di

import com.wind.domain.di.ioDispatcherTag
import com.wind.domain.usecase.GetTopAnimeUseCase
import com.wind.domain.usecase.GetTopMangaUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

/**
 * Created by Phong Huynh on 10/4/2020
 */
val homeVModule = DI.Module("homeVM") {
    bind<GetTopMangaUseCase>() with provider {
        GetTopMangaUseCase(instance(ioDispatcherTag), instance())
    }
    bind<GetTopAnimeUseCase>() with provider {
        GetTopAnimeUseCase(instance(ioDispatcherTag), instance())
    }
}