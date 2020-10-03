package com.wind.domain.usecase

import com.wind.data.Repository
import com.wind.data.model.NetworkAnime
import com.wind.domain.UseCase
import com.wind.domain.di.IoDispatcher
import com.wind.domain.mapper.impl.AnimeDataMapper
import com.wind.domain.model.Anime
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Phong Huynh on 9/28/2020
 */
class GetTopAnimeUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: Repository
) : UseCase<Unit, List<Anime>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Anime> {
        return repository.getTopAnime().data
            .map {
                AnimeDataMapper().map(it)
            }.filter {
                it.isValid()
            }
    }
}