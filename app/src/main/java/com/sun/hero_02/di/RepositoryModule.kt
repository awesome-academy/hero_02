package com.sun.hero_02.di

import com.sun.hero_02.data.repository.HeroRepository
import com.sun.hero_02.data.repository.HeroRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl(get(), get())
    }
}
