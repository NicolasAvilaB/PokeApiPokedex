package com.pokemon.ui.pokeapipokedex.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object AppModule {

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @JvmStatic
    fun provideApplication(application: Application): Application {
        return application
    }
}