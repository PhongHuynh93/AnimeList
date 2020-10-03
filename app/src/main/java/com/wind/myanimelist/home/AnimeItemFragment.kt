package com.wind.myanimelist.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.wind.model.Anime
import com.wind.myanimelist.databinding.FragmentItemAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Phong Huynh on 9/26/2020
 */
private const val EXTRA_DATA = "xData"

@AndroidEntryPoint
class AnimeItemFragment : Fragment() {
    private lateinit var viewBinding: FragmentItemAnimeBinding
    private val vmAnime by viewModels<AnimeViewModel>()

    companion object {
        fun newInstance(anime: Anime): AnimeItemFragment {
            return AnimeItemFragment().apply {
                arguments = bundleOf(EXTRA_DATA to anime)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentItemAnimeBinding.inflate(inflater, container, false).apply {
            vm = vmAnime.apply {
                setAnime(requireArguments().getParcelable(EXTRA_DATA)!!)
            }
            requestManager = Glide.with(this@AnimeItemFragment)
            lifecycleOwner = viewLifecycleOwner
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}