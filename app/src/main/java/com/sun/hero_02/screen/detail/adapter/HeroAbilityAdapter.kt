package com.sun.hero_02.screen.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sun.hero_02.R
import com.sun.hero_02.data.model.HeroSpell
import com.sun.hero_02.databinding.ItemHeroAbilityBinding

class HeroAbilityAdapter : ListAdapter<HeroSpell, HeroAbilityAdapter.ViewHolder>(HeroAbilityDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHeroAbilityBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_hero_ability,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class ViewHolder(
        private val binding: ItemHeroAbilityBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = ItemHeroAbilityViewModel()
        }

        fun bind(spell: HeroSpell) {
            binding.apply {
                viewModel?.heroSpell = spell
                executePendingBindings()
            }
        }
    }
}
