package com.wind.domain.usecase

import com.wind.data.Repository
import com.wind.domain.UseCase
import com.wind.domain.di.IoDispatcher
import com.wind.model.Anime
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
        return repository.getTopAnime().data.map { manga ->
            // replace with bigger image
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