package com.wind.domain.usecase

import com.wind.data.Repository
import com.wind.domain.UseCase
import com.wind.domain.di.IoDispatcher
import com.wind.model.Manga
import com.wind.model.TopList
import kotlinx.coroutines.CoroutineDispatcher
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Phong Huynh on 9/26/2020
 */
class GetTopMangaUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: Repository
) : UseCase<Unit, List<Manga>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Manga> {
        return repository.getTopManga().manga.map {manga ->
            val smallImage = manga.imageUrl
            manga.copy(imageUrl = if (smallImage == null) {
                null
            } else {
                val largeImage = smallImage.substring(0, smallImage.indexOf('?')).let {
                    it.substring(0, it.lastIndexOf('.')) + 'l' + it.substring(it.lastIndexOf('.'), it.length)
                }
                largeImage
            })
        }
    }
}
