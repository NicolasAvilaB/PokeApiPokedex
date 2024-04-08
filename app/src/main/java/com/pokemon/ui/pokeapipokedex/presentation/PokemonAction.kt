package com.pokemon.ui.pokeapipokedex.presentation

sealed class PokemonAction {
    data class GetListPokemonAction(val number: Int): PokemonAction()
}