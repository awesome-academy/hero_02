package com.sun.hero_02.data.model

import com.sun.hero_02.R
import com.sun.hero_02.utils.HeroDifficulty

enum class HeroDifficulties(val icon: Int, val difficulties: String) {
    CLASS(R.drawable.ic_all_class, HeroDifficulty.ANY.nameDiff),
    EASY(R.drawable.ic_easy, HeroDifficulty.EASY.nameDiff),
    AVERAGE(R.drawable.ic_average, HeroDifficulty.AVERAGE.nameDiff),
    HARD(R.drawable.ic_hard, HeroDifficulty.HARD.nameDiff),
    SEVERE(R.drawable.ic_severe, HeroDifficulty.SEVERE.nameDiff)
}
