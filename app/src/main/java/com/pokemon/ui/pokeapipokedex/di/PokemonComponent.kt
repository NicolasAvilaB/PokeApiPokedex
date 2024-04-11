package com.pokemon.ui.pokeapipokedex.di

import android.content.Context
import com.pokemon.ui.pokeapipokedex.MainActivity
import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.RetrofitModule
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.di.ProviderModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Component(
    modules = [
        AppModule::class,
        ProviderModule::class,
        RetrofitModule::class
    ]
)
interface PokemonComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): PokemonComponent
    }

    fun repository(): PokemonRepository

    fun inject(activity: MainActivity)

}