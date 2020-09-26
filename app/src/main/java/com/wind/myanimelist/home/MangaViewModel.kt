package com.wind.myanimelist.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wind.model.Manga

/**
 * Created by Phong Huynh on 9/26/2020
 */
class MangaViewModel @ViewModelInject constructor() : ViewModel() {
    private val _manga: MutableLiveData<Manga> = MutableLiveData()
    val manga: LiveData<Manga> = _manga

    fun setManga(manga: Manga) {
        _manga.value = manga
    }
}