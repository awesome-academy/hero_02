package com.sun.hero_02.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sun.hero_02.utils.Constant
import com.sun.hero_02.utils.HeroImageType
import com.sun.hero_02.utils.HeroImageType.*

fun ImageView.loadHeroImage(imageName: String?, type: HeroImageType) {
    val url = Constant.BASE_URL + when (type) {
        SKIN -> "${Constant.PATH_IMAGE_SKIN}/"
        SQUARE -> "${Constant.BASE_VERSION}/${Constant.PATH_IMAGE_CHAMPION}/"
        SPELL -> "${Constant.BASE_VERSION}/${Constant.PATH_IMAGE_SKILL}/"
        PASSIVE -> "${Constant.BASE_VERSION}/${Constant.PATH_IMAGE_PASSIVE}/"
    }
    imageName?.let {
        Glide.with(this.context)
            .load(url + imageName)
            .into(this)
    }
}

fun ImageView.loadImageLocal(url: Int) {
    Glide.with(this)
        .load(url)
        .into(this)
}
