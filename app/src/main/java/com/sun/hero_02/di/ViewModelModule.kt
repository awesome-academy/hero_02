package com.sun.hero_02.di

import com.sun.hero_02.screen.`class`.ClassViewModel
import com.sun.hero_02.screen.champions.ChampionsViewModel
import com.sun.hero_02.screen.favorite.FavoriteViewModel
import com.sun.hero_02.screen.home.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { HomeViewModel() }

    viewModel { ClassViewModel() }

    viewModel { ChampionsViewModel() }

    viewModel { FavoriteViewModel(get()) }
}
