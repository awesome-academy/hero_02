package com.sun.hero_02.screen.favorite

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override val viewModel: FavoriteViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentFavoriteBinding.inflate(inflater)

    override fun setUpView() {
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = FavoriteFragment()
    }
}
