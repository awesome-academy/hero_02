package com.sun.hero_02.data.repository.source.remote

import com.sun.hero_02.data.model.ChampionsResponse
import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.data.repository.source.remote.api.ApiService

class HeroRemoteImpl(private val apiService: ApiService) : HeroDataSource.Remote {

    override suspend fun getChampions() = apiService.getChampions()
}
