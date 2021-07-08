package com.sun.hero_02.data.model

import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("full")
    val image: String?,
)
