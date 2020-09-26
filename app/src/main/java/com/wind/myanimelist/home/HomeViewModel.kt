package com.wind.myanimelist.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wind.domain.data
import com.wind.domain.usecase.GetTopMangaUseCase
import com.wind.model.TopList
import kotlinx.coroutines.launch
import timber.log.Timber
import util.Event

/**
 * Created by Phong Huynh on 9/26/2020
 */
class HomeViewModel@ViewModelInject constructor(private val getTopMangaUseCase: GetTopMangaUseCase) : ViewModel() {
    private val _topManga: MutableLiveData<TopList> = MutableLiveData()
    val topManga: LiveData<TopList> = _topManga

    init {
        Timber.e("launch")
        viewModelScope.launch {
            val result = getTopMangaUseCase(Unit)
            Timber.e("${result.data}")
            _topManga.value = result.data
        }
    }
}