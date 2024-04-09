package com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events

import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon

sealed class ListPokemonUIState {
    object LoadingUiState : ListPokemonUIState()
    data class DisplayListPokemonUiState(
        val listPokemon: RemoteListPokemon,
    ) : ListPokemonUIState()
    data class ErrorUiState(val error: Throwable): ListPokemonUIState()
}