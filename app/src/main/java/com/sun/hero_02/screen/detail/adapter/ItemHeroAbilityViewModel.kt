package com.sun.hero_02.screen.detail.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.hero_02.data.model.HeroSpell
import com.sun.hero_02.utils.HeroImageType
import com.sun.hero_02.utils.HeroSpellSymbol

class ItemHeroAbilityViewModel : BaseObservable() {

    @Bindable
    var heroSpell: HeroSpell? = null
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    val spellType
        get() = if (heroSpell?.id == HeroSpellSymbol.PASSIVE) {
            HeroImageType.PASSIVE.ordinal
        } else {
            HeroImageType.SPELL.ordinal
        }
}
