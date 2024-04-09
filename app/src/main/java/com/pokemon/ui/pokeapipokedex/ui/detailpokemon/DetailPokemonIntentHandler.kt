package com.pokemon.ui.pokeapipokedex.ui.detailpokemon

import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent.GetDetailPokemonUIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge

class DetailPokemonIntentHandler {

    private val detailPokemonIntents = MutableSharedFlow<DetailPokemonUIntent>()

    internal fun detailPokemonUIntents(
        namePokemon: String
    ): Flow<DetailPokemonUIntent> = merge(
        flow { emit(GetDetailPokemonUIntent(namePokemon = namePokemon)) },
        detailPokemonIntents.asSharedFlow()
    )
}