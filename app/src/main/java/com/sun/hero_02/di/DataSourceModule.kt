package com.sun.hero_02.di

import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.data.repository.source.local.HeroLocalDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    single<HeroDataSource.Local> {
        HeroLocalDataSource(get())
    }
}
