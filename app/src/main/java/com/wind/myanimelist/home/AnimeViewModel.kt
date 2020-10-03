package com.wind.myanimelist.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wind.domain.model.Anime

/**
 * Created by Phong Huynh on 9/26/2020
 */
class AnimeViewModel @ViewModelInject constructor() : ViewModel() {
    private val _anime: MutableLiveData<Anime> = MutableLiveData()
    val anime: LiveData<Anime> = _anime

    fun setAnime(anime: Anime) {
        _anime.value = anime
    }
}