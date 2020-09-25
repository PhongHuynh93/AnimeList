package com.wind.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopList(
    @SerialName("request_cache_expiry")
    val requestCacheExpiry: Int,
    @SerialName("request_cached")
    val requestCached: Boolean,
    @SerialName("request_hash")
    val requestHash: String,
    @SerialName("top")
    val manga: List<Manga> = emptyList()
)

@Serializable
data class Manga(
    @SerialName("end_date")
    val endDate: String?,
    @SerialName("episodes")
    val episodes: Int?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("members")
    val members: Int,
    @SerialName("rank")
    val rank: Int,
    @SerialName("score")
    val score: Int,
    @SerialName("start_date")
    val startDate: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String?
)
