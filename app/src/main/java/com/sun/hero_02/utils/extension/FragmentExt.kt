package com.sun.hero_02.utils.extension

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.sun.hero_02.R

fun Fragment.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false,
    tag: String = fragment::class.java.simpleName) {
    activity?.supportFragmentManager?.apply {
        beginTransaction()
            .addToBackStack(tag)
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_in_right,
                R.anim.slide_out_right,
                R.anim.slide_out_right)
            .add(containerId, fragment, tag)
            .commit()
    }
}
