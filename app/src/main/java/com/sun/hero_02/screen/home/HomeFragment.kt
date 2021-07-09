package com.sun.hero_02.screen.home

import android.view.LayoutInflater
import com.sun.hero_02.R
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentHomeBinding
import com.sun.hero_02.screen.group.HeroGroupFragment
import com.sun.hero_02.screen.champions.ChampionsFragment
import com.sun.hero_02.screen.favorite.FavoriteFragment
import com.sun.hero_02.utils.ItemBottomNav
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    override fun setUpView() {
        val listFragment = listOf(
            ChampionsFragment.newInstance(),
            HeroGroupFragment.newInstance(),
            FavoriteFragment.newInstance()
        )
        viewBinding.viewPagerHome.run {
            isUserInputEnabled = false
            adapter = HomeAdapter(this@HomeFragment, listFragment)
        }
    }

    override fun bindView() {
        registerEventNavigation()
    }

    private fun registerEventNavigation() = with(viewBinding) {
        bottomNavigationHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemChampion -> {
                    viewPagerHome.currentItem = ItemBottomNav.CHAMPION_ITEM.ordinal
                    true
                }
                R.id.itemClass -> {
                    viewPagerHome.currentItem = ItemBottomNav.CLASS_ITEM.ordinal
                    true
                }
                R.id.itemFavorite -> {
                    viewPagerHome.currentItem = ItemBottomNav.FAVORITE_ITEM.ordinal
                    true
                }
                else -> true
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
