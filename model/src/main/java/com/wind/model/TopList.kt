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

