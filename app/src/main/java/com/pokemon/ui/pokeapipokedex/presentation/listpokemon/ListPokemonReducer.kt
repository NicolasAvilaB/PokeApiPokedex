package com.pokemon.ui.pokeapipokedex.presentation.listpokemon

import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonResult.GetListPokemonResult.Error
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonResult.GetListPokemonResult.InProgress
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonResult.GetListPokemonResult.Success
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.DisplayListPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.LoadingUiState

class ListPokemonReducer {

    private fun unsupportedReduceCase() = RuntimeException()

    infix fun ListPokemonUIState.reduceWith(result: ListPokemonResult): ListPokemonUIState {
        return when (val previousState = this) {
            is ErrorUiState -> previousState reduceWith result
            is DisplayListPokemonUiState -> previousState reduceWith result
            is LoadingUiState -> previousState reduceWith result
        }
    }

    private infix fun LoadingUiState.reduceWith(result: ListPokemonResult) = when (result) {
        is Error -> ErrorUiState(result.error)
        is Success -> DisplayListPokemonUiState(result.listPokemon)
        is InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun ErrorUiState.reduceWith(result: ListPokemonResult) = when (result) {
        is InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun DisplayListPokemonUiState.reduceWith(result: ListPokemonResult) = when (result) {
        is InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

}