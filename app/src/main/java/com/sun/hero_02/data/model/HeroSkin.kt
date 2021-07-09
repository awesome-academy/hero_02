package com.sun.hero_02.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroSkin(
    val id: String?,
    val num: Int?,
    val name: String?
) : Parcelable
