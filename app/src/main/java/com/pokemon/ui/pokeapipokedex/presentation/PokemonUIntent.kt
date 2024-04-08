package com.pokemon.ui.pokeapipokedex.presentation

sealed class PokemonUIntent {
    data class GetListPokemonUIntent(val number: Int) : PokemonUIntent()
}