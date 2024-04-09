package com.testlistdog.ui.listdogs.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonReducer

internal class ListPokemonFactory (
    private val reducer : ListPokemonReducer,
    private val processor : ListPokemonProcessor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            ListPokemonReducer::class.java,
            ListPokemonProcessor::class.java
        ).newInstance(reducer,processor)
    }
}

internal inline fun <reified T : ViewModel> getFactoryViewModel(
    activity: ComponentActivity,
    reducer: ListPokemonReducer,
    processor: ListPokemonProcessor
): T {
    return ViewModelProvider(
        activity,
        ListPokemonFactory(
            reducer = reducer,
            processor = processor
        )
    )[T::class.java]
}