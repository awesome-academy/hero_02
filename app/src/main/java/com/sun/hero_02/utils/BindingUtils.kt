package com.sun.hero_02.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sun.hero_02.R
import com.sun.hero_02.utils.HeroDifficulty.*
import com.sun.hero_02.utils.extension.loadHeroImage
import com.sun.hero_02.utils.extension.loadImageLocal

object BindingUtils {
    @JvmStatic
    @BindingAdapter(value = ["app:url", "app:placeHolder"], requireAll = false)
    fun ImageView.loadImageUrl(url: String?, placeHolder: Int?) {
        url?.let {
            placeHolder?.let {
                this.loadHeroImage(url, HeroImageType.values()[it])
            }
        }
    }

    @JvmStatic
    @BindingAdapter("app:loadImageLocal")
    fun ImageView.setHeroGroupImage(url: Int?) {
        url?.let {
            this.loadImageLocal(it)
        }
    }

    @JvmStatic
    @BindingAdapter("app:iconDifficulty")
    fun ImageView.setIconDifficulty(difficulty: String) = setImageResource(
        when (difficulty) {
            SEVERE.nameDiff -> R.drawable.ic_severe
            HARD.nameDiff -> R.drawable.ic_hard
            AVERAGE.nameDiff -> R.drawable.ic_average
            else -> R.drawable.ic_easy
        }
    )

    @JvmStatic
    @BindingAdapter("app:iconTag")
    fun ImageView.setIconTag(tag: String?) = setImageResource(
        when (tag) {
            HeroGroup.ASSASSIN.tag ->  R.drawable.ic_assassin
            HeroGroup.FIGHTER.tag ->  R.drawable.ic_fighter
            HeroGroup.MAGE.tag ->  R.drawable.ic_mage
            HeroGroup.MARKSMAN.tag ->  R.drawable.ic_marksman
            HeroGroup.SUPPORT.tag ->  R.drawable.ic_support
            HeroGroup.TANK.tag ->  R.drawable.ic_tank
            else -> R.drawable.ic_all_class
        }
    )
}
