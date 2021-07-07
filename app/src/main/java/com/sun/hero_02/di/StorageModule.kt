package com.sun.hero_02.di

import android.content.Context
import com.sun.hero_02.data.repository.source.local.room.DatabaseBuilder
import com.sun.hero_02.data.repository.source.local.room.HeroFavoriteDatabase
import org.koin.dsl.module

val storageModule = module {

    fun buildRoomDB(context: Context) = DatabaseBuilder().buildRoomDB(context)

    fun provideImageDao(favoriteDatabase: HeroFavoriteDatabase) = favoriteDatabase.heroFavoriteDao

    single { buildRoomDB(get()) }
    single { provideImageDao(get()) }
}
