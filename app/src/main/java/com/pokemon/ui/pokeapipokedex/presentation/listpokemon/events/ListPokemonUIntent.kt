package com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events

sealed class ListPokemonUIntent {
    data class GetListPokemonUIntent(val number: Int) : ListPokemonUIntent()
}