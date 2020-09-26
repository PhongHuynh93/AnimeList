package com.wind.myanimelist.home

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2

/**
 * Created by Phong Huynh on 9/26/2020
 * https://stackoverflow.com/questions/56114430/android-viewpager2-setpagemargin-unresolved
 */
class MarginPageTransform(
    private val viewPager: ViewPager2,
    private val pageMarginPx: Int,
    private val offsetPx: Int
) : ViewPager2.PageTransformer {

    init {
        viewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }
    }

    override fun transformPage(page: View, position: Float) {
        val offset = position * -(2 * offsetPx + pageMarginPx)
        if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                page.translationX = -offset
            } else {
                page.translationX = offset
            }
        } else {
            page.translationY = offset
        }
    }
}