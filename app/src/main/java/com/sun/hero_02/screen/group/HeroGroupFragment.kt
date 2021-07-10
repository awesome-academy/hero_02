package com.sun.hero_02.screen.group

import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import com.sun.hero_02.base.BaseFragment
import com.sun.hero_02.data.model.CategoryHero
import com.sun.hero_02.data.model.getHeroDifficulty
import com.sun.hero_02.data.model.getHeroGroups
import com.sun.hero_02.databinding.FragmentGroupBinding
import com.sun.hero_02.screen.champions.adapter.ChampionsAdapter
import com.sun.hero_02.screen.group.adapter.SpinnerAdapter
import com.sun.hero_02.utils.HeroDifficulty
import com.sun.hero_02.utils.HeroGroup
import kotlinx.android.synthetic.main.fragment_group.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroGroupFragment : BaseFragment<FragmentGroupBinding, HeroGroupViewModel>() {

    override val viewModel: HeroGroupViewModel by viewModel()

    private var className: String? = null
    private var difficulty: HeroDifficulty? = null
    private val championsAdapter by lazy {
        ChampionsAdapter {}
    }

    override fun inflateViewBinding(inflater: LayoutInflater) =
        FragmentGroupBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.apply {
            lifecycleOwner = this@HeroGroupFragment
            viewModel = this@HeroGroupFragment.viewModel
            recyclerViewHero.adapter = championsAdapter
            spinnerClass.adapter = SpinnerAdapter(requireContext(), getHeroGroups())
            spinnerDifficulty.adapter = SpinnerAdapter(requireContext(), getHeroDifficulty())
        }
    }

    override fun bindView() {
        setupObserver()
        onEvent()
    }

    private fun onEvent() {
        spinnerClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val heroClass = parent?.getItemAtPosition(position) as CategoryHero
                className = if (heroClass.nameGroup.equals(HeroGroup.ANY_CLASS.tag))
                    null
                else
                    heroClass.nameGroup
                viewModel.apply {
                    getHeroFilter(className, difficulty)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinnerDifficulty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val heroDifficulty = parent?.getItemAtPosition(position) as CategoryHero
                difficulty = when (heroDifficulty.nameGroup) {
                    HeroDifficulty.EASY.nameDiff -> HeroDifficulty.EASY
                    HeroDifficulty.AVERAGE.nameDiff -> HeroDifficulty.AVERAGE
                    HeroDifficulty.HARD.nameDiff -> HeroDifficulty.HARD
                    HeroDifficulty.SEVERE.nameDiff -> HeroDifficulty.SEVERE
                    else -> null
                }
                viewModel.apply {
                    getHeroFilter(className, difficulty)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupObserver() = with(viewModel) {
        getHeroFilter(className, difficulty)
        champions.observe(viewLifecycleOwner, {
            championsAdapter.submitList(it)
        })
    }

    companion object {
        fun newInstance() = HeroGroupFragment()
    }
}
