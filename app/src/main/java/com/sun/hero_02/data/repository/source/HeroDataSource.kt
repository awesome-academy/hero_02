package com.sun.hero_02.data.repository.source

import com.sun.hero_02.data.model.HeroFavorite

interface HeroDataSource {

    interface Local {
        suspend fun getAllFavorite(): MutableList<HeroFavorite>

        suspend fun checkFavorite(id: String?): HeroFavorite?

        suspend fun searchFavorite(id: String?): HeroFavorite?

        suspend fun addFavorite(favorite: HeroFavorite)

        suspend fun deleteFavorite(favorite: HeroFavorite)
    }
}
