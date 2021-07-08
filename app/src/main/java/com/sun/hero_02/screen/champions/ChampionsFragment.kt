package com.sun.hero_02.screen.champions

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentChampionsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionsFragment : BaseFragment<FragmentChampionsBinding, ChampionsViewModel>() {

    override val viewModel: ChampionsViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentChampionsBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@ChampionsFragment
            viewModel = this@ChampionsFragment.viewModel
        }
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = ChampionsFragment()
    }
}
