package com.sun.hero_02.data.repository

import com.sun.hero_02.base.BaseRepository
import com.sun.hero_02.data.repository.source.HeroDataSource

class HeroRepositoryImpl(
    private val local: HeroDataSource.Local,
    private val remote: HeroDataSource.Remote
) : HeroRepository, BaseRepository() {

    override suspend fun getChampions() = withResultContext {
        val result = remote.getChampions()
        return@withResultContext result.championItems.values.toMutableList()
    }

    override suspend fun getChampionDetail(idHero: String) = withResultContext {
        val result = remote.getChampionDetail(idHero)
        return@withResultContext result.championItems.getValue(idHero)
    }
}
