package com.pokemon.ui.pokeapipokedex.ui.detailpokemon

import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent.GetDetailPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailPokemonIntentHandler @Inject constructor(){

    var coroutineScope: CoroutineScope? = null

    private val detailPokemonIntents = MutableSharedFlow<DetailPokemonUIntent>()

    internal fun detailPokemonUIntents(
        namePokemon: String
    ): Flow<DetailPokemonUIntent> = merge(
        flow { emit(GetDetailPokemonUIntent(namePokemon = namePokemon)) },
        detailPokemonIntents.asSharedFlow()
    )

    internal fun retryIntent(namePokemon: String) =
        coroutineScope?.launch {
            detailPokemonIntents.emit(DetailPokemonUIntent.RetryUIntent(namePokemon))
        }
}