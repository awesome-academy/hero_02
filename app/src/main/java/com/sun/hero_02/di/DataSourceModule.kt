package com.sun.hero_02.di

import com.sun.hero_02.data.repository.source.HeroDataSource
import com.sun.hero_02.data.repository.source.local.HeroLocalImpl
import com.sun.hero_02.data.repository.source.remote.HeroRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<HeroDataSource.Local> {
        HeroLocalImpl()
    }

    single<HeroDataSource.Remote> {
        HeroRemoteImpl(get())
    }
}
