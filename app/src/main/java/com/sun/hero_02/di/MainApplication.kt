package com.sun.hero_02.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            viewModelModule,
            repositoryModule,
            dataSourceModule,
            storageModule
        )
        startKoin {
            androidLogger(org.koin.core.logger.Level.NONE)
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}
