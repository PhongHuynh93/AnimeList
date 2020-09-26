package com.wind.myanimelist.home

import android.content.Context
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import util.dp
import kotlin.math.abs

/**
 * Created by Phong Huynh on 9/26/2020
 */
// this is the min scale of a page
private const val MIN_SCALE = 0.62f
class ScalePageTransform(context: Context, private val viewPager: ViewPager2): ViewPager2.PageTransformer {
    private var maxTranslateOffsetX: Float = 180 * context.dp()
    private var margin: Float = 48 * context.dp()

    override fun transformPage(view: View, position: Float) {
        val leftInScreen = view.left - viewPager.scrollX
        val centerXInVPager = leftInScreen + view.measuredWidth / 2
        val offsetX = centerXInVPager - viewPager.measuredWidth / 2
        val offsetRate = offsetX * (1f - MIN_SCALE) / viewPager.measuredWidth
        val scaleFactor = 1 - abs(offsetRate)

        // handle margin
        val offset: Float = margin * position

//        if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
//            view.translationX = -offset
//        } else {
//            view.translationY = offset
//        }
        if (scaleFactor > 0) {
            view.apply {
                scaleX = scaleFactor
                scaleY = scaleFactor
                translationX = -maxTranslateOffsetX * offsetRate
            }
        }
//        Timber.e("view ${view.hashCode()} $leftInScreen $centerXInVPager $offsetX $offsetRate $scaleFactor")

    }
}