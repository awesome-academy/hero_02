package com.sun.hero_02.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.HeroDetail
import com.sun.hero_02.data.model.HeroSpell
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import com.sun.hero_02.utils.HeroSpellSymbol
import com.sun.hero_02.utils.Status
import kotlinx.coroutines.launch

class DetailViewModel(private val heroRepository: HeroRepository) : ViewModel() {

    private val _champion = MutableLiveData<HeroDetail>()
    val champion: LiveData<HeroDetail>
        get() = _champion

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private fun changeSpellNameToSymbol(data: HeroDetail): HeroDetail {
        val listSpells = mutableListOf<HeroSpell>()
        data.run {
            passive?.let {
                listSpells.add(
                    HeroSpell(
                        HeroSpellSymbol.PASSIVE,
                        it.name,
                        it.description,
                        it.image
                    )
                )
            }
            spells?.let {
                for (item in it) {
                    listSpells.add(
                        HeroSpell(
                            HeroSpellSymbol.SKILL[it.indexOf(item)],
                            item.name,
                            item.description,
                            item.image
                        )
                    )
                }
            }
        }
        return data.apply { spells = listSpells }
    }

    fun changeImageSkinUrl(data: HeroDetail): HeroDetail {
        return data.apply {
            data.skins?.forEach {
                it.id = "${data.id}_${it.num}.jpg"
            }
        }
    }

    fun getChampion(idHero: String) {
        viewModelScope.launch {
            _status.value = Status.LOADING
            when (val response = heroRepository.getChampionDetail(idHero)) {
                is DataResult.Success -> {
                    _champion.value = changeSpellNameToSymbol(changeImageSkinUrl(response.data))
                    _status.value = Status.SUCCESS
                }
                is DataResult.Error -> {
                    _champion.value = null
                    _status.value = Status.ERROR
                }
            }
        }
    }
}
