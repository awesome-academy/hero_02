package com.sun.hero_02.utils

object Constant {
    const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/"
    const val BASE_LANGUAGE = "data/en_US"
    const val BASE_VERSION = "11.9.1"
    const val PATH_CHAMPION_DETAIL = "champion"
    const val PATH_IMAGE_SKILL = "img/spell"
    const val PATH_IMAGE_PASSIVE = "img/passive"
    const val PATH_IMAGE_SKIN = "img/champion/splash"
    const val PATH_IMAGE_CHAMPION = "img/champion"
    const val PATH_LIST_CHAMPION = "champion.json"
}

object HeroSpellSymbol {
    const val PASSIVE = "P"
    val SKILL = mutableListOf("Q", "W", "E", "R")
}

enum class HeroImageType {
    SQUARE, SKIN, SPELL, PASSIVE
}

enum class HeroGroup(val tag: String) {
    ANY_CLASS("Any Class"),
    ASSASSIN("Assassin"),
    FIGHTER("Fighter"),
    MAGE("Mage"),
    TANK("Tank"),
    SUPPORT("Support"),
    MARKSMAN("Marksman")
}
