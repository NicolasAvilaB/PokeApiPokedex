package com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events

sealed class ListPokemonUIntent {
    data class GetListPokemonUIntent(val number: Int) : ListPokemonUIntent()
    data class RetryIntent(val number: Int) : ListPokemonUIntent()
}