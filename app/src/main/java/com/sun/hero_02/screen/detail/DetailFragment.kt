package com.sun.hero_02.screen.detail

import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.databinding.FragmentDetailBinding
import com.sun.hero_02.screen.champions.adapter.ChampionsAdapter
import com.sun.hero_02.screen.detail.adapter.HeroAbilityAdapter
import com.sun.hero_02.utils.BindingUtils.loadImageUrl
import com.sun.hero_02.utils.BindingUtils.setIconTag
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private var idHero: String? = null

    override val viewModel: DetailViewModel by viewModel()

    private val abilityAdapter by lazy {
        HeroAbilityAdapter()
    }

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentDetailBinding.inflate(inflater)

    override fun setUpView() {
        arguments?.let {
            idHero = it.getString(ARGUMENT_HERO_ID).toString()
        }
        viewBinding.apply {
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            recyclerHeroAbility.adapter = abilityAdapter
        }
    }

    override fun bindView() {
        idHero?.let { viewModel.getChampion(it) }
        setupObserver()
    }

    private fun setupObserver() = with(viewModel) {
        champion.observe(viewLifecycleOwner, {
            abilityAdapter.submitList(it.spells)
            bindHeroTag(it.tags)
        })
    }

    private fun bindHeroTag(tags: List<String>?) {
        if (tags?.size ?: 0 > 1) {
            val primaryTag = tags?.get(0)
            val secondaryTag = tags?.get(1)
            with(viewBinding) {
                textPrimaryTag.text = primaryTag
                textSecondaryTag.text = secondaryTag
                imagePrimaryTag.run {
                    visibility = View.VISIBLE
                    setIconTag(primaryTag)
                }
                imageSecondaryTag.run {
                    visibility = View.VISIBLE
                    setIconTag(secondaryTag)
                }
            }
        } else {
            val primaryTag = tags?.get(0)
            with(viewBinding) {
                textPrimaryTag.text = primaryTag
                imagePrimaryTag.setIconTag(primaryTag)
                imageSecondaryTag.visibility = View.INVISIBLE
                textSecondaryTag.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        private const val ARGUMENT_HERO_ID = "ARGUMENT_HERO_ID"

        fun newInstance(idHero: String?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_HERO_ID to idHero)
        }
    }
}
