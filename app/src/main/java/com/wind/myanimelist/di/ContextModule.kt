package com.wind.myanimelist.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.wind.myanimelist.home.HomeAdapter
import com.wind.myanimelist.home.HomeAnimeHozAdapter
import com.wind.myanimelist.home.HomeMangaHozAdapter
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider

/**
 * Created by Phong Huynh on 10/4/2020
 */
fun homeModule(frag: Fragment) = DI.Module("home") {
    bind<HomeAdapter>() with provider {
        val applicationContext = frag.requireContext().applicationContext
        val homeMangaAdapter = HomeMangaHozAdapter(Glide.with(frag))
        val homeAnimeHozAdapter = HomeAnimeHozAdapter(Glide.with(frag))
        HomeAdapter(applicationContext, homeMangaAdapter, homeAnimeHozAdapter)
    }
}