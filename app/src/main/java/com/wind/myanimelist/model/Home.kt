package com.wind.myanimelist.model

import com.wind.domain.model.Anime
import com.wind.domain.model.Manga
import com.wind.myanimelist.util.AdapterTypeUtil

/**
 * Created by Phong Huynh on 9/29/2020
 */

interface HomeItem {
    fun getType(): Int
}

data class HomeManga(
    val list: List<Manga>
): HomeItem {
    override fun getType(): Int {
        return AdapterTypeUtil.TYPE_MANGA_SLIDER
    }
}

data class HomeAnime(
    val list: List<Anime>
): HomeItem {
    override fun getType(): Int {
        return AdapterTypeUtil.TYPE_ANIME_SLIDER
    }
}

data class Title(val resId: Int): HomeItem {
    override fun getType(): Int {
        return AdapterTypeUtil.TYPE_TITLE
    }

}