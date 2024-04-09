package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon

import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonResult.GetDetailPokemonResult.Error
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonResult.GetDetailPokemonResult.InProgress
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonResult.GetDetailPokemonResult.Success
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.DisplayDetailPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.LoadingUiState

class DetailPokemonReducer {
    private fun unsupportedReduceCase() = RuntimeException()

    infix fun DetailPokemonUIState.reduceWith(result: DetailPokemonResult): DetailPokemonUIState {
        return when (val previousState = this) {
            is ErrorUiState -> previousState reduceWith result
            is DisplayDetailPokemonUiState -> previousState reduceWith result
            is LoadingUiState -> previousState reduceWith result
        }
    }

    private infix fun LoadingUiState.reduceWith(result: DetailPokemonResult) =
        when (result) {
            is Error -> ErrorUiState(result.error)
            is Success -> DisplayDetailPokemonUiState(result.detailPokemon)
            is InProgress -> LoadingUiState
            else -> throw unsupportedReduceCase()
        }

    private infix fun ErrorUiState.reduceWith(result: DetailPokemonResult) =
        when (result) {
            is InProgress -> LoadingUiState
            else -> throw unsupportedReduceCase()
        }

    private infix fun DisplayDetailPokemonUiState.reduceWith(result: DetailPokemonResult) =
        when (result) {
            is InProgress -> LoadingUiState
            else -> throw unsupportedReduceCase()
        }
}