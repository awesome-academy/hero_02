package com.sun.hero_02.data.repository.source.local

import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.data.repository.source.local.room.HeroFavoriteDao

class HeroLocalDataSource(
    private val heroFavoriteDao: HeroFavoriteDao
) : HeroDataSource.Local{

    override suspend fun getAllFavorite() = heroFavoriteDao.getAllFavorite()

    override suspend fun checkFavorite(id: String?) = heroFavoriteDao.checkFavorite(id)

    override suspend fun searchFavorite(id: String?) = heroFavoriteDao.searchFavorite(id)

    override suspend fun addFavorite(favorite: HeroFavorite) = heroFavoriteDao.addFavorite(favorite)

    override suspend fun deleteFavorite(favorite: HeroFavorite) = heroFavoriteDao.deleteFavorite(favorite)
}
