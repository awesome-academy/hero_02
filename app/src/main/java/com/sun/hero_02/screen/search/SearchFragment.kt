package com.sun.hero_02.screen.search

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@SearchFragment
            viewModel = this@SearchFragment.viewModel
        }
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
