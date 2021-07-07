package com.sun.hero_02.data.repository.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sun.hero_02.data.model.HeroFavorite

@Dao
interface HeroFavoriteDao {

    @Query("SELECT * FROM heroFavorite")
    suspend fun getAllFavorite(): MutableList<HeroFavorite>

    @Query("SELECT * FROM heroFavorite WHERE id LIKE :id")
    suspend fun checkFavorite(id : String?): HeroFavorite?

    @Query("SELECT * FROM heroFavorite WHERE id LIKE '%' || :id || '%'")
    suspend fun searchFavorite(id : String?): HeroFavorite?

    @Insert
    suspend fun addFavorite(favorite: HeroFavorite)

    @Delete
    suspend fun deleteFavorite(favorite: HeroFavorite)
}
