package com.wind.myanimelist.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.wind.model.Manga
import com.wind.myanimelist.R
import com.wind.myanimelist.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import util.dp

/**
 * Created by Phong Huynh on 9/26/2020
 */
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewBinding: FragmentHomeBinding
    private val vmHome by viewModels<HomeViewModel>()

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            vm = vmHome
            lifecycleOwner = viewLifecycleOwner
            viewPager2.apply {
                adapter = PagerAdapter(this@HomeFragment)
                val compositePageTransformer = CompositePageTransformer().apply {
                    addTransformer(ScalePageTransform(requireContext(), viewPager2))
                    addTransformer(MarginPageTransform(viewPager2, (48 * dp()).toInt(), (48 * dp()).toInt()))
                }
                setPageTransformer(compositePageTransformer)
            }
        }
        return viewBinding.root
    }
}

@BindingAdapter("data")
fun ViewPager2.loadData(data: List<Manga>?) {
    data?.let {
        (adapter as PagerAdapter).setData(data)
    }
}


private class PagerAdapter(frag: Fragment) : FragmentStateAdapter(frag) {
    private var data = emptyList<Manga>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return MangaFragment.newInstance(data[position])
    }

    fun setData(data: List<Manga>) {
        this.data = data
        notifyDataSetChanged()
    }
}
