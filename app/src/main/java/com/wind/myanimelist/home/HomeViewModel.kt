package com.wind.myanimelist.home

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.wind.domain.data
import com.wind.domain.succeeded
import com.wind.domain.usecase.GetTopMangaUseCase
import com.wind.model.Manga
import com.wind.model.TopList
import com.wind.myanimelist.R
import kotlinx.coroutines.launch
import timber.log.Timber
import util.Event

/**
 * Created by Phong Huynh on 9/26/2020
 */
class HomeViewModel@ViewModelInject constructor(private val getTopMangaUseCase: GetTopMangaUseCase) : ViewModel() {
    private val _topManga: MutableLiveData<List<Manga>> = MutableLiveData()
    val topManga: LiveData<List<Manga>> = _topManga

    init {
        viewModelScope.launch {
            val result = getTopMangaUseCase(Unit)
            _topManga.value = result.data
        }
    }
}