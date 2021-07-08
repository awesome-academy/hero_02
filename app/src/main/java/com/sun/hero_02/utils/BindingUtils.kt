package com.sun.hero_02.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sun.hero_02.R
import com.sun.hero_02.utils.HeroDifficulty.*
import com.sun.hero_02.utils.extension.loadHeroImage

object BindingUtils {
    @JvmStatic
    @BindingAdapter("app:heroImage")
    fun ImageView.setHeroImage(url: String?) {
        url?.let {
            this.loadHeroImage(it, HeroImageType.SQUARE)
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
}
