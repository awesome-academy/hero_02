package com.sun.hero_02.data.model

data class HeroDetail(
    val id: String?,
    val name: String?,
    val title: String?,
    val image: HeroImage?,
    val skins: List<HeroSkin>?,
    val lore: String?,
    val tags: List<String>?,
    val info: HeroInfo?,
    val stats: HeroStats?,
    var spells: List<HeroSpell>?,
    val passive: HeroSpell?,
    var isFavorite: Boolean = false
)

