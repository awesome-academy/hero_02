package com.sun.hero_02.screen.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sun.hero_02.R
import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.databinding.ItemLayoutFavoriteBinding

class FavoriteAdapter(
    private val onFavoriteClick: (String) -> Unit,
    private val onItemDeleteClick: (HeroFavorite) -> Unit
) : ListAdapter<HeroFavorite, FavoriteAdapter.ViewHolder>(FavoriteDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            DataBindingUtil.inflate<ItemLayoutFavoriteBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_layout_favorite,
                parent,
                false)
        return ViewHolder(binding, onFavoriteClick, onItemDeleteClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class ViewHolder(
        private val binding: ItemLayoutFavoriteBinding,
        private val onItemClicked: (String) -> Unit,
        private val onItemDeleteClick: (HeroFavorite) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.heroFavorite = ItemFavoriteViewModel()
        }

        fun bind(favorite: HeroFavorite) {
            binding.apply {
                heroFavorite?.favorite = favorite
                executePendingBindings()
                imageHeroFavorite.setOnClickListener {
                    onItemClicked(favorite.id)
                }
                imageViewLikeFavorite.setOnClickListener {
                    onItemDeleteClick(favorite)
                }
            }
        }
    }
}
