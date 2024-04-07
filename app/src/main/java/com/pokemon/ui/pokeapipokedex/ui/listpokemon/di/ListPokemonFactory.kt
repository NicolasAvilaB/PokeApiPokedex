package com.testlistdog.ui.listdogs.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pokemon.ui.pokeapipokedex.data.ListPokemonRepository
import com.pokemon.ui.pokeapipokedex.presentation.PokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.PokemonReducer

internal class ListPokemonFactory (
    private val reducer : PokemonReducer,
    private val processor : PokemonProcessor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            PokemonReducer::class.java,
            PokemonProcessor::class.java
        ).newInstance(reducer,processor)
    }
}

internal inline fun <reified T : ViewModel> getFactoryViewModel(
    activity: ComponentActivity,
    reducer: PokemonReducer,
    processor: PokemonProcessor
): T {
    return ViewModelProvider(
        activity,
        ListPokemonFactory(
            reducer = reducer,
            processor = processor
        )
    )[T::class.java]
}