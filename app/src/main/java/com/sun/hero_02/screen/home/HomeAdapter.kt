package com.sun.hero_02.screen.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(
    fragment: Fragment,
    private var fragments: List<Fragment>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}
