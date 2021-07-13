package com.sun.hero_02.screen.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sun.hero_02.data.model.HeroSpell

class HeroAbilityDiffUtil : DiffUtil.ItemCallback<HeroSpell>() {

    override fun areItemsTheSame(oldItem: HeroSpell, newItem: HeroSpell) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HeroSpell, newItem: HeroSpell) =
        oldItem == newItem
}
