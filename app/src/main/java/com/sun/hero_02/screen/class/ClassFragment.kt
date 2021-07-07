package com.sun.hero_02.screen.`class`

import android.view.LayoutInflater
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentClassBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClassFragment : BaseFragment<FragmentClassBinding, ClassViewModel>() {

    override val viewModel: ClassViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentClassBinding.inflate(inflater)

    override fun setUpView() {
    }

    override fun bindView() {
    }

    companion object {
        fun newInstance() = ClassFragment()
    }
}
