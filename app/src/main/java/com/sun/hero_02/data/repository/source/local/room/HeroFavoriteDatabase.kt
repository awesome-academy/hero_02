package com.sun.hero_02.data.repository.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sun.hero_02.data.model.HeroFavorite

@Database(entities = [HeroFavorite::class], version = 1)
abstract class HeroFavoriteDatabase : RoomDatabase(){

    abstract val heroFavoriteDao : HeroFavoriteDao
}
