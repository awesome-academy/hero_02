package com.sun.hero_02.data.repository.source.local.room

import android.content.Context
import androidx.room.Room
import com.sun.hero_02.utils.Constant

class DatabaseBuilder {

    fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            HeroFavoriteDatabase::class.java,
            Constant.DATABASE_NAME
        ).build()
}
