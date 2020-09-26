package com.wind.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: 9/26/2020 create mapper to upper layer
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

@Parcelize
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
): Parcelable
