package com.wind.myanimelist.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.wind.myanimelist.R

/**
 * Created by Phong Huynh on 9/26/2020
 */
@BindingAdapter("requestManager", "image")
fun ImageView.loadImage(requestManager: RequestManager, url: String?) {
    requestManager
        .load(url)
        .into(this)
}
