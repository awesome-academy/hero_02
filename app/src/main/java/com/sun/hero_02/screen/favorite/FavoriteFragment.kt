package com.sun.hero_02.screen.favorite

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.databinding.FragmentFavoriteBinding
import com.sun.hero_02.screen.favorite.adapter.FavoriteAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    private val favoriteAdapter by lazy{
        FavoriteAdapter({
            showHeroDetail(it)
        },{
            deleteFavorite(it)
        })
    }

    private fun showHeroDetail(id: String) {
    }

    private fun deleteFavorite(favorite: HeroFavorite) {
    }

    override val viewModel: FavoriteViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentFavoriteBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@FavoriteFragment
            adapter = favoriteAdapter
        }
    }

    override fun bindView() = with(viewModel) {
        viewModel.getFavorite()
        favorite.observe(viewLifecycleOwner, Observer{
            favoriteAdapter.submitList(it)
            favoriteAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        fun newInstance() = FavoriteFragment()
    }
}
