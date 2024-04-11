package com.pokemon.ui.pokeapipokedex.ui.listpokemon.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.PokemonRemoteImpl
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.PokemonWebService
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.RetrofitModule
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonReducer
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonViewModel
import dagger.Module
import dagger.Provides

@Module
class ProviderModule {
    @OptIn(ExperimentalAnimationApi::class)

    @Provides
    fun provideListPokemonViewModel(
        reducer: ListPokemonReducer,
        processor: ListPokemonProcessor
    ): ListPokemonViewModel {
        return ListPokemonViewModel(reducer, processor)
    }

    @Provides
    fun provideListPokemonProcessor(repository: PokemonRepository): ListPokemonProcessor {
        return ListPokemonProcessor(repository)
    }

    @Provides
    fun providePokemonRepository(remote: PokemonSourceRemote): PokemonRepository {
        return PokemonRepository(remote)
    }

    @Provides
    fun providePokemonSourceRemote(webService: PokemonWebService): PokemonSourceRemote {
        return PokemonRemoteImpl(webService)
    }

    @Provides
    fun providePokemonWebService(retrofitModule: RetrofitModule): PokemonWebService {
        return retrofitModule.provideRetrofit().create(PokemonWebService::class.java)
    }
}