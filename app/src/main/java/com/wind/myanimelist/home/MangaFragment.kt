package com.wind.myanimelist.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.wind.model.Manga
import com.wind.myanimelist.R
import com.wind.myanimelist.databinding.FragmentMangaBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Phong Huynh on 9/26/2020
 */
private const val EXTRA_DATA = "xData"
@AndroidEntryPoint
class MangaFragment: Fragment() {
    private lateinit var viewBinding: FragmentMangaBinding
    private val vmManga by viewModels<MangaViewModel>()

    companion object {
        fun newInstance(manga: Manga): MangaFragment {
            return MangaFragment().apply {
                arguments = bundleOf(EXTRA_DATA to manga)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMangaBinding.inflate(inflater, container, false).apply {
            vm = vmManga.apply {
                setManga(requireArguments().getParcelable(EXTRA_DATA)!!)
            }
            requestManager = Glide.with(this@MangaFragment)
            lifecycleOwner = viewLifecycleOwner
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}