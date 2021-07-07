package com.sun.hero_02.screen.favorite.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sun.hero_02.data.model.HeroFavorite

class FavoriteDiffUtil: DiffUtil.ItemCallback<HeroFavorite>() {

    override fun areItemsTheSame(oldItem: HeroFavorite, newItem: HeroFavorite) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HeroFavorite, newItem: HeroFavorite) =
        oldItem == newItem
}
