package com.sun.hero_02.data.model

import com.google.gson.annotations.SerializedName

data class ChampionsResponse (
    @SerializedName("data")
    val championItems: Map<String, Hero>
)
