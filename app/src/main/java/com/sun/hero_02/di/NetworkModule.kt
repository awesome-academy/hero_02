package com.sun.hero_02.di

import com.sun.hero_02.data.repository.source.remote.api.ApiService
import com.sun.hero_02.data.repository.source.remote.api.ServiceGenerator
import com.sun.hero_02.utils.Constant
import org.koin.dsl.module

val networkModule = module {
    single {
        ServiceGenerator.generate(
            baseUrl = Constant.BASE_URL,
            serviceClass = ApiService::class.java
        )
    }
}
