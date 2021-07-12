package com.sun.hero_02.data.model

import com.sun.hero_02.R
import com.sun.hero_02.utils.HeroGroup

enum class HeroGroups(val icon: Int, val group: String) {
    CLASS(R.drawable.ic_all_class, HeroGroup.ANY_CLASS.tag),
    ASSASSIN(R.drawable.ic_assassin, HeroGroup.ASSASSIN.tag),
    FIGHTER(R.drawable.ic_fighter, HeroGroup.FIGHTER.tag),
    MAGE(R.drawable.ic_mage, HeroGroup.MAGE.tag),
    TANK(R.drawable.ic_tank, HeroGroup.TANK.tag),
    SUPPORT(R.drawable.ic_support, HeroGroup.SUPPORT.tag),
    MARKSMAN(R.drawable.ic_marksman, HeroGroup.MARKSMAN.tag)
}
