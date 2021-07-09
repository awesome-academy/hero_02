package com.sun.hero_02.data.repository.source.remote.api

import com.sun.hero_02.data.model.ChampionsResponse
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.model.HeroDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("11.9.1/data/en_US/champion.json")
    suspend fun getChampions(): ChampionsResponse<Hero>

    @GET("11.9.1/data/en_US/champion/{id}.json")
    suspend fun getChampionDetail(@Path("id") id: String): ChampionsResponse<HeroDetail>
}
