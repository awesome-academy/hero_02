package com.sun.hero_02.data.model

data class Hero (
    val id: String?,
    val name: String?,
    val title: String?,
    val info : HeroInfo?,
    val image : HeroImage?,
    val tags : List<String>,
)
