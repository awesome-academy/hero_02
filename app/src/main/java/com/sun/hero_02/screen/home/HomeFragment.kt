package com.sun.hero_02.screen.home

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    override fun setUpView() {
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
