package com.sun.hero_02.screen.group.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.hero_02.data.model.CategoryHero

class ItemGroupViewModel : BaseObservable() {

    @Bindable
    var hero: CategoryHero? = null
        set(value) {
            field = value
            notifyChange()
        }
}
