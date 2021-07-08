package com.sun.hero_02.screen.champions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sun.hero_02.R
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.databinding.ItemHeroBinding

class ChampionsAdapter(
    private var clickListener: (Hero) -> Unit
) : ListAdapter<Hero, ChampionsAdapter.ViewHolder>(HeroDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHeroBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_hero,
            parent,
            false
        )
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class ViewHolder(
        private val binding: ItemHeroBinding,
        private val onItemClicked: (Hero) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = ItemHeroViewModel()
        }

        fun bind(hero: Hero) {
            binding.apply {
                viewModel?.hero = hero
                executePendingBindings()
            }
        }
    }
}
