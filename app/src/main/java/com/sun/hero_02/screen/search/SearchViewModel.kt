package com.sun.hero_02.screen.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import com.sun.hero_02.utils.Status
import kotlinx.coroutines.launch

class SearchViewModel(
    private val heroRepository: HeroRepository
): ViewModel() {
    private val _champions = MutableLiveData<MutableList<Hero>>()
    val champions: LiveData<MutableList<Hero>>
        get() = _champions

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    fun searchHero(query: String){
        viewModelScope.launch {
            _status.value = Status.LOADING
            when (val response = heroRepository.getChampions()) {
                is DataResult.Success -> {
                    _champions.value = getDataFilter(response.data,query)
                    _status.value = Status.SUCCESS
                }
                is DataResult.Error -> {
                    _champions.value = null
                    _status.value = Status.ERROR
                }
            }
        }
    }

    private fun getDataFilter(data: MutableList<Hero>, nameHero: String): MutableList<Hero> {
        val heroes = mutableListOf<Hero>()
        for (hero in data) {
            hero.name?.let {
                if (it.startsWith(nameHero, true)) {
                    heroes.add(hero)
                }
            }
        }
        return heroes
    }
}
