package com.sun.hero_02.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sun.hero_02.utils.extension.loadImage

object BindingUtils {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        url?.let {
            this.loadImage(it)
        }
    }
}
