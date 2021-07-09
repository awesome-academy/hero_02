package com.sun.hero_02.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.HeroDetail
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import com.sun.hero_02.utils.Status
import kotlinx.coroutines.launch

class DetailViewModel(private val heroRepository: HeroRepository) : ViewModel() {

    private val _champion = MutableLiveData<HeroDetail>()
    val champion: LiveData<HeroDetail>
        get() = _champion

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    fun getChampion(idHero: String) {
        viewModelScope.launch {
            _status.value = Status.LOADING
            when (val response = heroRepository.getChampionDetail(idHero)) {
                is DataResult.Success -> {
                    _champion.value = response.data
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
