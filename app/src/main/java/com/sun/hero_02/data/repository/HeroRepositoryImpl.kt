package com.sun.hero_02.data.repository

import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.utils.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroRepositoryImpl(
    private val local: HeroDataSource.Local
): HeroRepository{

    /**
     * Local
     */
    override suspend fun getAllFavorite() = withContext(Dispatchers.Default){
        var favoriteList: MutableList<HeroFavorite>
        try {
            local.getAllFavorite().also {
                favoriteList = it}
            return@withContext DataResult.Success(favoriteList)
        } catch (ex: Exception) {
            return@withContext DataResult.Error(ex)
        }
    }

    override suspend fun checkFavorite(id: String?) = local.checkFavorite(id)

    override suspend fun searchFavorite(id: String?) = local.searchFavorite(id)

    override suspend fun addFavorite(favorite: HeroFavorite) = local.addFavorite(favorite)

    override suspend fun deleteFavorite(favorite: HeroFavorite) = local.deleteFavorite(favorite)

    /**
     * Remote
     */
}
