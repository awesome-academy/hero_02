package com.sun.hero_02.data.model

import com.google.gson.annotations.SerializedName

data class HeroStats(
    @SerializedName("hp")
    val hp: Float?,
    @SerializedName("movespeed")
    val moveSpeed: Float?,
    @SerializedName("armor")
    val armor: Float?,
    @SerializedName("spellblock")
    val spellBlock: Float?,
    @SerializedName("attackrange")
    val attackRange: Float?,
    @SerializedName("hpregen")
    val hpRegen: Float?,
    @SerializedName("attackdamage")
    val attackDamage: Float?,
    @SerializedName("attackspeed")
    val attackSpeed: Float?
)
