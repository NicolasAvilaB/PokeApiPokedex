package com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events

sealed class ListPokemonAction {
    data class GetListPokemonAction(val number: Int): ListPokemonAction()
}