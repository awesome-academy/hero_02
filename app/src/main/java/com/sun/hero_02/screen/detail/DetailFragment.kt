package com.sun.hero_02.screen.detail

import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private var idHero: String? = null

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentDetailBinding.inflate(inflater)

    override fun setUpView() {
        arguments?.let {
            idHero = it.getString(ARGUMENT_HERO_ID).toString()
        }
        viewBinding.apply {
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
        }
    }

    override fun bindView() {
        idHero?.let { viewModel.getChampion(it) }
    }

    companion object {
        private const val ARGUMENT_HERO_ID = "ARGUMENT_HERO_ID"

        fun newInstance(idHero: String?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_HERO_ID to idHero)
        }
    }
}
