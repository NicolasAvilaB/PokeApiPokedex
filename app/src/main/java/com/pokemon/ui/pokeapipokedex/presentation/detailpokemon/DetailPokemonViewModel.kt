package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonAction.GetDetailPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent.GetDetailPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

class DetailPokemonViewModel(
    private val reducer : DetailPokemonReducer,
    private val processor : DetailPokemonProcessor
) : ViewModel() {

    val loadingUiState: DetailPokemonUIState = LoadingUiState
    private val detailtokemonUiState: MutableStateFlow<DetailPokemonUIState> =
        MutableStateFlow(loadingUiState)

    fun detailViewPokemonState(): StateFlow<DetailPokemonUIState> =
        detailtokemonUiState.asStateFlow()

    fun processUserIntentDetailPokemon(
        detailtPokemonIntents: Flow<DetailPokemonUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        detailtPokemonIntents.buffer()
            .flatMapMerge { detailPokemonIntent ->
                processor.actionProcessor(detailPokemonIntent.toAction())
            }
            .scan(loadingUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { detailtPokemonstate ->
                detailtokemonUiState.value = detailtPokemonstate
            }
            .launchIn(coroutineScope)
    }

    private fun DetailPokemonUIntent.toAction(): DetailPokemonAction {
        return when (this) {
            is GetDetailPokemonUIntent -> GetDetailPokemonAction(
                this.namePokemon
            )
        }
    }
}