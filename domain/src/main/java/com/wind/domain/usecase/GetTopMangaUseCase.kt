package com.wind.domain.usecase

import com.wind.data.Repository
import com.wind.domain.UseCase
import com.wind.domain.di.IoDispatcher
import com.wind.model.Manga
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Phong Huynh on 9/26/2020
 */
class GetTopMangaUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: Repository
) : UseCase<Unit, List<Manga>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Manga> {
        return repository.getTopManga().data
    }
}
