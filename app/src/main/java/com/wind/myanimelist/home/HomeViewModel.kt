package com.wind.myanimelist.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wind.domain.data
import com.wind.domain.usecase.GetTopAnimeUseCase
import com.wind.domain.usecase.GetTopMangaUseCase
import com.wind.myanimelist.model.HomeAnime
import com.wind.myanimelist.model.HomeItem
import com.wind.myanimelist.model.HomeManga
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Phong Huynh on 9/26/2020
 */
class HomeViewModel @ViewModelInject constructor(
    private val getTopMangaUseCase: GetTopMangaUseCase,
    private val getTopAnimeUseCase: GetTopAnimeUseCase
) : ViewModel() {
    private val _data: MutableLiveData<List<HomeItem>> = MutableLiveData()
    val data: LiveData<List<HomeItem>> = _data

    init {
        viewModelScope.launch {
            val topMangaListDeferred = async {
                getTopMangaUseCase(Unit)
            }
            val topAnimeListDeferred = async {
                getTopAnimeUseCase(Unit)
            }
            val list = mutableListOf<HomeItem>()
            topMangaListDeferred.await().apply {
                data?.let {
                    list.add(HomeManga(it))
                }
            }
            topAnimeListDeferred.await().apply {
                data?.let {
                    list.add(HomeAnime(it))
                }
            }
            if (list.isEmpty()) {
                // TODO: 9/28/2020 show no data
            } else {
                _data.value = list
            }
        }
    }
}