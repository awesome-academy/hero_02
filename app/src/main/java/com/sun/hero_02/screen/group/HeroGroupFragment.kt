package com.sun.hero_02.screen.group

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentGroupBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroGroupFragment : BaseFragment<FragmentGroupBinding, HeroGroupViewModel>() {

    override val viewModel: HeroGroupViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentGroupBinding.inflate(inflater)

    override fun setUpView() {
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = HeroGroupFragment()
    }
}
