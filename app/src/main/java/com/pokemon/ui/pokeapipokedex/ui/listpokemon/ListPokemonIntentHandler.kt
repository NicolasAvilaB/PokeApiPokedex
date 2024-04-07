package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent.GetListPokemonUIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge

class ListPokemonIntentHandler {

    private val pokemonIntents = MutableSharedFlow<PokemonUIntent>()

    internal fun pokemonUIntents(): Flow<PokemonUIntent> =
        merge(flow { emit(GetListPokemonUIntent) }, pokemonIntents.asSharedFlow())
}