package com.sun.hero_02.screen.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.hero_02.data.model.HeroFavorite
import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.utils.DataResult
import kotlinx.coroutines.launch
import java.lang.Exception

class FavoriteViewModel(
    private val repository: HeroRepository
) : ViewModel() {

    private val _favorite = MutableLiveData<MutableList<HeroFavorite>>()
    val favorite: LiveData<MutableList<HeroFavorite>> get() = _favorite

    private val _exception = MutableLiveData<Exception>()
    val exception: MutableLiveData<Exception> get() = _exception

    fun getFavorite() {
        viewModelScope.launch {
            when (val response = repository.getAllFavorite()) {
                is DataResult.Success -> _favorite.value = response.data
                is DataResult.Error -> _exception.value = response.exception
            }
        }
    }
}
