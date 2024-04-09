package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events

sealed class DetailPokemonAction{
    data class GetDetailPokemonAction(
        val namePokemon: String
    ) : DetailPokemonAction()
}
