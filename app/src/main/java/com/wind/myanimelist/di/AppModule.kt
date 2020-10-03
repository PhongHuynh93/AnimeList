package com.wind.myanimelist.di

import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Created by Phong Huynh on 9/30/2020
 */
@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {
    @Provides
    fun getRequestManager(frag: Fragment): RequestManager {
        return Glide.with(frag)
    }
}