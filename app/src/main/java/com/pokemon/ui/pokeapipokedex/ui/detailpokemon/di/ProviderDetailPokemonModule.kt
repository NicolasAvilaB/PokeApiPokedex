package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.PokemonRemoteImpl
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.PokemonWebService
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.RetrofitModule
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonReducer
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonViewModel
import dagger.Module
import dagger.Provides

@Module
class ProviderDetailPokemonModule {
    @OptIn(ExperimentalAnimationApi::class)
    @Provides
    fun provideDetailPokemonViewModel(
        reducer: DetailPokemonReducer,
        processor: DetailPokemonProcessor
    ): DetailPokemonViewModel {
        return DetailPokemonViewModel(reducer, processor)
    }

    @Provides
    fun provideDetailPokemonProcessor(repository: PokemonRepository): DetailPokemonProcessor {
        return DetailPokemonProcessor(repository)
    }

    @Provides
    fun provideDetailPokemonRepository(remote: PokemonSourceRemote): PokemonRepository {
        return PokemonRepository(remote)
    }

    @Provides
    fun provideDetailPokemonSourceRemote(webService: PokemonWebService): PokemonSourceRemote {
        return PokemonRemoteImpl(webService)
    }

    @Provides
    fun provideDetailPokemonWebService(retrofitModule: RetrofitModule): PokemonWebService {
        return retrofitModule.provideRetrofit().create(PokemonWebService::class.java)
    }
}