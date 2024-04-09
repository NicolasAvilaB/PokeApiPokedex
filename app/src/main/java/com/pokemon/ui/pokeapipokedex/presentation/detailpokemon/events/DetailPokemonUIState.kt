package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events

import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
sealed class DetailPokemonUIState{
    object LoadingUiState : DetailPokemonUIState()
    data class DisplayDetailPokemonUiState(
        val detailPokemon: RemoteListDetailPokemon,
    ) : DetailPokemonUIState()
    data class ErrorUiState(val error: Throwable): DetailPokemonUIState()
}
