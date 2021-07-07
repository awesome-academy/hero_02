package com.sun.hero_02.screen.favorite.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.hero_02.data.model.HeroFavorite

class ItemFavoriteViewModel : BaseObservable(){

    @Bindable
    var favorite: HeroFavorite? = null
        set(value) {
            field = value
        }
}
