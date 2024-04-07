package com.testlistdog.ui.listdogs.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pokemon.ui.pokeapipokedex.data.ListPokemonRepository

internal class ListPokemonFactory (
    private val repository: ListPokemonRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            ListPokemonRepository::class.java
        ).newInstance(repository)
    }
}

internal inline fun <reified T : ViewModel> getFactoryViewModel(
    activity: ComponentActivity,
    repository: ListPokemonRepository
): T {
    return ViewModelProvider(
        activity,
        ListPokemonFactory(
            repository = repository
        )
    )[T::class.java]
}