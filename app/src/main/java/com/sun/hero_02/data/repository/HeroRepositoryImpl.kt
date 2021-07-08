package com.sun.hero_02.data.repository

import com.sun.hero_02.base.BaseRepository
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.utils.DataResult

class HeroRepositoryImpl(
    private val local: HeroDataSource.Local,
    private val remote: HeroDataSource.Remote
) : HeroRepository, BaseRepository() {

    override suspend fun getChampions() = withResultContext {
        val result = remote.getChampions()
        return@withResultContext result.championItems.values.toMutableList()
    }
}
