package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent.GetListPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ListPokemonIntentHandler {

    val pokemonIntents = MutableSharedFlow<PokemonUIntent>()
    var coroutineScope: CoroutineScope? = null

    internal fun pokemonUIntents(): Flow<PokemonUIntent> = pokemonIntents.asSharedFlow()

    fun getListPokemon() {
        coroutineScope?.launch {
            pokemonIntents.emit(GetListPokemonUIntent)
        }
    }
}