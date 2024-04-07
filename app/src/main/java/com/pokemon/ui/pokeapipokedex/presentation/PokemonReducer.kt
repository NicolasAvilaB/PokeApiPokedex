package com.pokemon.ui.pokeapipokedex.presentation

import com.pokemon.ui.pokeapipokedex.presentation.PokemonResult.GetListPokemonResult
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.DisplayListPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.LoadingUiState

class PokemonReducer {

    private fun unsupportedReduceCase() = RuntimeException()

    infix fun PokemonUIState.reduceWith(result: PokemonResult): PokemonUIState {
        return when (val previousState = this) {
            is ErrorUiState -> previousState reduceWith result
            is DisplayListPokemonUiState -> previousState reduceWith result
            is LoadingUiState -> previousState reduceWith result
        }
    }

    private infix fun LoadingUiState.reduceWith(result: PokemonResult) = when (result) {
        is GetListPokemonResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun ErrorUiState.reduceWith(result: PokemonResult) = when (result) {
        is GetListPokemonResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

    private infix fun DisplayListPokemonUiState.reduceWith(result: PokemonResult) = when (result) {
        is GetListPokemonResult.Error -> ErrorUiState
        is GetListPokemonResult.Success -> DisplayListPokemonUiState(result.listPokemon)
        is GetListPokemonResult.InProgress -> LoadingUiState
        else -> throw unsupportedReduceCase()
    }

}