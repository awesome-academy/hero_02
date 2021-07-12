package com.sun.hero_02.screen.champions.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.utils.HeroDifficulty.*
import com.sun.hero_02.utils.HeroImageType

class ItemHeroViewModel : BaseObservable() {
    @Bindable
    var hero: Hero? = null
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    val difficulty : String
        get() = when (hero?.info?.difficulty) {
            in SEVERE.diff -> SEVERE.nameDiff
            in HARD.diff -> HARD.nameDiff
            in AVERAGE.diff -> AVERAGE.nameDiff
            in EASY.diff -> EASY.nameDiff
            else -> ANY.nameDiff
        }

    @get:Bindable
    val imageType
        get() = HeroImageType.SQUARE.ordinal
}
