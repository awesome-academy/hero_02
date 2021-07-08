package com.sun.hero_02.screen.champions.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sun.hero_02.data.model.Hero

class HeroDiffUtil : DiffUtil.ItemCallback<Hero>() {

    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem == newItem
}
