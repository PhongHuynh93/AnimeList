package com.wind.data

import com.wind.model.Anime
import com.wind.model.Manga
import com.wind.model.TopList
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Created by Phong Huynh on 9/24/2020
 */
interface Repository {
    suspend fun getTopAnime(): TopList<Anime>
    suspend fun getTopManga(): TopList<Manga>
}

private const val baseUrl = "https://api.jikan.moe/v3"
internal class RepositoryImpl internal constructor(private val client: HttpClient) : Repository {
    override suspend fun getTopAnime(): TopList<Anime> {
        val url = "${baseUrl}/top/anime/1/upcoming"
        return client.get(url)
    }

    override suspend fun getTopManga(): TopList<Manga> {
        val url = "${baseUrl}/top/manga/1/manga"
        return client.get(url)
    }
}