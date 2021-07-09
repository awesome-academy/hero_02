package com.sun.hero_02.screen.search

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentSearchBinding
import com.sun.hero_02.screen.champions.adapter.ChampionsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    private val search = ""

    override val viewModel: SearchViewModel by viewModel()

    private val championsAdapter by lazy {
        ChampionsAdapter {}
    }

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@SearchFragment
            viewModel = this@SearchFragment.viewModel
            recyclerViewHero.adapter = championsAdapter
        }
    }

    override fun bindView() {
        setupObserver()
        onEvent()
    }

    private fun onEvent() {
        viewBinding.apply {
            buttonSearch.setOnClickListener {
                viewModel?.searchHero(editTextHeroName.text.toString())
            }
        }
    }

    private fun setupObserver() = with(viewModel) {
        searchHero(search)
        champions.observe(viewLifecycleOwner, {
            championsAdapter.submitList(it)
        })
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
