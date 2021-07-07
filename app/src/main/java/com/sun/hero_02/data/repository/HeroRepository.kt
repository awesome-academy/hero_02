package com.sun.hero_02.data.repository

import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.utils.DataResult

interface HeroRepository {

    /**
     * Local
     */
    suspend fun getAllFavorite(): DataResult<MutableList<HeroFavorite>>

    suspend fun checkFavorite(id: String?): HeroFavorite?

    suspend fun searchFavorite(id: String?): HeroFavorite?

    suspend fun addFavorite(favorite: HeroFavorite)

    suspend fun deleteFavorite(favorite: HeroFavorite)

    /**
     * Remote
     */
}
