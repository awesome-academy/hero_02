package com.sun.hero_02.screen.champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.Hero
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import com.sun.hero_02.utils.Status
import kotlinx.coroutines.launch

class ChampionsViewModel(private val heroRepository: HeroRepository) : ViewModel() {

    private val _champions = MutableLiveData<MutableList<Hero>>()
    val champions: LiveData<MutableList<Hero>>
        get() = _champions

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status


    init {
        getChampions()
    }

    private fun getChampions() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            when (val response = heroRepository.getChampions()) {
                is DataResult.Success -> {
                    _champions.value = response.data
                    _status.value = Status.SUCCESS
                }
                is DataResult.Error -> {
                    _champions.value = null
                    _status.value = Status.ERROR
                }
            }
        }
    }
}
