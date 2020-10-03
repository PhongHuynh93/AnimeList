package com.wind.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Manga(
//    @SerialName("end_date")
//    val endDate: Any?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("mal_id")
    val id: Int,
    @SerialName("members")
    val members: Int,
    @SerialName("rank")
    val rank: Int,
    @SerialName("score")
    val score: Double,
    @SerialName("start_date")
    val startDate: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String,
//    @SerialName("volumes")
//    val volumes: Any?
) : Parcelable
