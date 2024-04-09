package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonReducer

internal class DetailPokemonFactory (
    private val reducer : DetailPokemonReducer,
    private val processor : DetailPokemonProcessor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            DetailPokemonReducer::class.java,
            DetailPokemonProcessor::class.java
        ).newInstance(reducer,processor)
    }
}

internal inline fun <reified T : ViewModel> getDetailFactoryViewModel(
    activity: ComponentActivity,
    reducer: DetailPokemonReducer,
    processor: DetailPokemonProcessor
): T {
    return ViewModelProvider(
        activity,
        DetailPokemonFactory(
            reducer = reducer,
            processor = processor
        )
    )[T::class.java]
}