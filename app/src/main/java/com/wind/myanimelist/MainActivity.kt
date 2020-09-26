package com.wind.myanimelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wind.myanimelist.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import util.addFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(HomeFragment.newInstance(), R.id.root)
        }
    }
}