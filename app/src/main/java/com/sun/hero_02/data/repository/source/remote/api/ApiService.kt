package com.sun.hero_02.data.repository.source.remote.api

import com.sun.hero_02.data.model.ChampionsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("11.9.1/data/en_US/champion.json")
    suspend fun getChampions(): ChampionsResponse
}
