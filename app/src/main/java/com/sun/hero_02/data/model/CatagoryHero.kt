package com.sun.hero_02.data.model

data class CategoryHero(
    val image: Int,
    val nameGroup: String
)

fun getHeroGroups(): MutableList<CategoryHero> {
    val listGroup = mutableListOf<CategoryHero>()
    for (i in HeroGroups.values().indices) {
        val heroGroup = HeroGroups.values()[i]
        listGroup.add(CategoryHero(heroGroup.icon, heroGroup.group))
    }
    return listGroup
}

fun getHeroDifficulty(): MutableList<CategoryHero> {
    val listDifficulties = mutableListOf<CategoryHero>()
    for (i in HeroDifficulties.values().indices) {
        val difficulty = HeroDifficulties.values()[i]
        listDifficulties.add(CategoryHero(difficulty.icon, difficulty.difficulties))
    }
    return listDifficulties
}
