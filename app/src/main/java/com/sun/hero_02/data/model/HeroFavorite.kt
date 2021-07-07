package com.sun.hero_02.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "heroFavorite")
@Parcelize
data class HeroFavorite(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "url_image")
    val urlImage: String?
) : Parcelable
