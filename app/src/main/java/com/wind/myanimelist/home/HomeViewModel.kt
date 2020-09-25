package com.wind.myanimelist.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wind.domain.data
import com.wind.domain.usecase.GetTopMangaUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by Phong Huynh on 9/26/2020
 */
class HomeViewModel@ViewModelInject constructor(private val getTopMangaUseCase: GetTopMangaUseCase) : ViewModel() {
    init {
        Timber.e("launch")
        viewModelScope.launch {
            val result = getTopMangaUseCase(Unit)
            Timber.e("${result.data}")
        }
    }
}