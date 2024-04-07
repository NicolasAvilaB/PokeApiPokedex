package com.pokemon.ui.pokeapipokedex.presentation

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon

sealed class PokemonUIState {
    object LoadingUiState : PokemonUIState()
    data class DisplayListPokemonUiState(
        val listPokemon: List<RemoteListPokemon?>?,
    ) : PokemonUIState()
    object ErrorUiState: PokemonUIState()
}