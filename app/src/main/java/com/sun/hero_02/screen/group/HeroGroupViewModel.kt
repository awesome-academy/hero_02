package com.sun.hero_02.screen.group

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import com.sun.hero_02.utils.HeroDifficulty
import com.sun.hero_02.utils.Status
import kotlinx.coroutines.launch

class HeroGroupViewModel(
    private val heroRepository: HeroRepository
) : ViewModel() {

    private val _champions = MutableLiveData<MutableList<Hero>>()
    val champions: LiveData<MutableList<Hero>>
        get() = _champions

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    fun getHeroFilter(classFilter: String?, difficultyFilter: HeroDifficulty?) {
        viewModelScope.launch {
            _status.value = Status.LOADING
            when (val response = heroRepository.getChampions()) {
                is DataResult.Success -> {
                    _champions.value = getDataFilter(response.data, classFilter, difficultyFilter)
                    _status.value = Status.SUCCESS
                }
                is DataResult.Error -> {
                    _champions.value = null
                    _status.value = Status.ERROR
                }
            }
        }
    }

    private fun getDataFilter(
        data: MutableList<Hero>,
        classFilter: String?,
        difficultyFilter: HeroDifficulty?
    ): MutableList<Hero> {
        val heroes = mutableListOf<Hero>()
        if (classFilter != null) {
            data.forEach {
                if (classFilter in it.tags) {
                    heroes += it
                }
            }
        } else {
            heroes.addAll(data)
        }
        if (difficultyFilter != null) {
            return heroes.filter {
                it.info?.difficulty in difficultyFilter.diff
            }.toMutableList()
        }
        return heroes
    }
}
