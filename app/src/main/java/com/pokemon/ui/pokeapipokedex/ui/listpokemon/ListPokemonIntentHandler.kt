package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent.GetListPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch

class ListPokemonIntentHandler {

    var coroutineScope: CoroutineScope? = null

    private val pokemonIntents = MutableSharedFlow<PokemonUIntent>()

    internal fun pokemonUIntents(number: Int): Flow<PokemonUIntent> =
        merge(flow { emit(GetListPokemonUIntent(number)) }, pokemonIntents.asSharedFlow())

    internal fun pagesPokemon(number: Int) =
        coroutineScope?.launch {
            pokemonIntents.emit(GetListPokemonUIntent(number))
        }
}