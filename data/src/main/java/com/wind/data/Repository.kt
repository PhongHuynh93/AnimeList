package com.wind.data

import com.wind.model.TopList
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Created by Phong Huynh on 9/24/2020
 */
interface Repository {
    suspend fun getTopManga(): TopList
}

val path = "https://api.jikan.moe/v3"
internal class RepositoryImpl internal constructor(private val client: HttpClient) : Repository {
    override suspend fun getTopManga(): TopList {
        val url = "${path}/top/anime/1/upcoming"
        return client.get<TopList>(url)
    }
}