package com.sun.hero_02.screen.champions

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentChampionsBinding
import com.sun.hero_02.screen.champions.adapter.ChampionsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionsFragment : BaseFragment<FragmentChampionsBinding, ChampionsViewModel>() {

    override val viewModel: ChampionsViewModel by viewModel()

    private val championsAdapter by lazy {
        ChampionsAdapter {}
    }

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentChampionsBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@ChampionsFragment
            viewModel = this@ChampionsFragment.viewModel
            recyclerViewHero.adapter = championsAdapter
        }
    }

    override fun bindView() {
        setupObserver()
    }

    private fun setupObserver() = with(viewModel) {
        champions.observe(viewLifecycleOwner, {
            championsAdapter.submitList(it)
        })
    }

    companion object {
        fun newInstance() = ChampionsFragment()
    }
}
