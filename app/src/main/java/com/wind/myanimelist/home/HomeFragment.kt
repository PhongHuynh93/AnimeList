package com.wind.myanimelist.home

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.RequestManager
import com.wind.model.Anime
import com.wind.model.Manga
import com.wind.myanimelist.R
import com.wind.myanimelist.databinding.FragmentHomeBinding
import com.wind.myanimelist.databinding.ItemAnimeHomePagerBinding
import com.wind.myanimelist.databinding.ItemMangaBinding
import com.wind.myanimelist.databinding.ItemMangaHomePagerBinding
import com.wind.myanimelist.model.HomeAnime
import com.wind.myanimelist.model.HomeItem
import com.wind.myanimelist.model.HomeManga
import com.wind.myanimelist.util.AdapterTypeUtil
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import util.dp
import util.getDimen
import javax.inject.Inject

/**
 * Created by Phong Huynh on 9/26/2020
 */
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewBinding: FragmentHomeBinding
    private val vmHome by viewModels<HomeViewModel>()
    @Inject
    lateinit var homeAdapter: HomeAdapter

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
            rcv.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = homeAdapter
            }
        }
        return viewBinding.root
    }
}

@BindingAdapter("data")
fun RecyclerView.loadData(data: List<HomeItem>?) {
    data?.let {
        (adapter as HomeAdapter).setData(it)
    }
}

class HomeAdapter @Inject constructor(@ApplicationContext private val applicationContext: Context, private val pagerMangaAdapter: PagerMangaAdapter, private val pagerAnimeAdapter: PagerAnimeAdapter) : ListAdapter<HomeItem, RecyclerView.ViewHolder>(object : DiffUtil
.ItemCallback<HomeItem>() {
    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return true
    }
}) {
    private val spaceNormal = applicationContext.getDimen(R.dimen.space_normal).toInt()

    init {
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    var callback: Callback? = null

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            AdapterTypeUtil.TYPE_MANGA_SLIDER -> {
                val binding = ItemMangaHomePagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HomeMangaPagerViewHolder(binding).apply {
                    itemView.setOnClickListener {
                        val pos = bindingAdapterPosition
                        if (pos >= 0) {
                            callback?.onClickManga(pos, getItem(pos) as HomeManga)
                        }
                    }
                }
            }
            AdapterTypeUtil.TYPE_ANIME_SLIDER -> {
                HomeAnimePagerViewHolder(ItemAnimeHomePagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
                    itemView.setOnClickListener {
                        val pos = bindingAdapterPosition
                        if (pos >= 0) {
                            callback?.onClickAnime(pos, getItem(pos) as HomeAnime)
                        }
                    }
                }
            }
            else -> {
                throw IllegalStateException("Not support viewType $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (getItemViewType(position)) {
            AdapterTypeUtil.TYPE_ANIME_SLIDER -> {
                val homePagerViewHolder = holder as HomeAnimePagerViewHolder
                homePagerViewHolder.binding.item = item as HomeAnime
                homePagerViewHolder.binding.executePendingBindings()
            }
            AdapterTypeUtil.TYPE_MANGA_SLIDER -> {
                val homePagerViewHolder = holder as HomeMangaPagerViewHolder
                homePagerViewHolder.binding.item = item as HomeManga
                homePagerViewHolder.binding.executePendingBindings()
            }
        }
    }

    fun setData(data: List<HomeItem>) {
        submitList(data)
    }

    interface Callback {
        fun onClickManga(pos: Int, homeManga: HomeManga)
        fun onClickAnime(pos: Int, homeAnime: HomeAnime)
    }


    inner class HomeMangaPagerViewHolder(val binding: ItemMangaHomePagerBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rcv.apply {
                adapter = pagerMangaAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                addItemDecoration(object: RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                    ) {
                        super.getItemOffsets(outRect, view, parent, state)
                        outRect.right = spaceNormal
                        val pos = parent.getChildAdapterPosition(view)
                        if (pos == 0) {
                            outRect.left = spaceNormal
                        }
                    }
                })
            }
        }
    }
    inner class HomeAnimePagerViewHolder(val binding: ItemAnimeHomePagerBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewPager2.adapter = pagerAnimeAdapter
            val compositePageTransformer = CompositePageTransformer().apply {
                addTransformer(ScalePageTransform(applicationContext, binding.viewPager2))
                addTransformer(
                    MarginPageTransform(
                        binding.viewPager2,
                        (48 * applicationContext.dp()).toInt(),
                        (48 * applicationContext.dp()).toInt()
                    )
                )
            }
            binding.viewPager2.setPageTransformer(compositePageTransformer)
        }
    }
}

@BindingAdapter("data")
fun RecyclerView.loadManga(data: List<Manga>?) {
    data?.let {
        (adapter as PagerMangaAdapter).submitList(data)
    }
}

@BindingAdapter("data")
fun ViewPager2.loadAnime(data: List<Anime>?) {
    data?.let {
        (adapter as PagerAnimeAdapter).setData(data)
    }
}

class PagerMangaAdapter @Inject constructor(private val requestManager: RequestManager): ListAdapter<Manga, PagerMangaAdapter.ViewHolder>(object : DiffUtil
.ItemCallback<Manga>() {
    override fun areItemsTheSame(oldItem: Manga, newItem: Manga): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Manga, newItem: Manga): Boolean {
        return oldItem == newItem
    }
}) {

    init {
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    var callback: Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            itemView.setOnClickListener { view ->
                val pos = bindingAdapterPosition
                if (pos >= 0) {
                    getItem(pos)?.let {
                        callback?.onClick(view, pos, it)
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
        holder.binding.requestManager = requestManager
        holder.binding.executePendingBindings()
    }

    interface Callback {
        fun onClick(view: View, pos: Int, item: Manga)
    }

    inner class ViewHolder(val binding: ItemMangaBinding) : RecyclerView.ViewHolder(binding.root)
}

class PagerAnimeAdapter @Inject constructor(frag: Fragment) : FragmentStateAdapter(frag) {
    private var data = emptyList<Anime>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return AnimeItemFragment.newInstance(data[position])
    }

    fun setData(data: List<Anime>) {
        this.data = data
        notifyDataSetChanged()
    }
}
