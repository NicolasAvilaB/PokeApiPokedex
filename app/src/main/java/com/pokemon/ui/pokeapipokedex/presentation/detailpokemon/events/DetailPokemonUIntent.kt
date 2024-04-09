package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events

sealed class DetailPokemonUIntent{
    data class GetDetailPokemonUIntent(val namePokemon: String) : DetailPokemonUIntent()
}
