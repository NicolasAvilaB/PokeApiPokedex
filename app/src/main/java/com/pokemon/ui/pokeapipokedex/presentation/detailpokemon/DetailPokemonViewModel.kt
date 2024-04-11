package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonAction.GetDetailPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent.GetDetailPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIntent.RetryUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

class DetailPokemonViewModel(
    private val reducer : DetailPokemonReducer,
    private val processor : DetailPokemonProcessor
) : ViewModel() {

    val loadingUiState: DetailPokemonUIState = LoadingUiState
    private val detailtokemonUiState: MutableSharedFlow<DetailPokemonUIState> =
        MutableSharedFlow(replay = 1)

    fun detailViewPokemonState(): Flow<DetailPokemonUIState> =
        detailtokemonUiState

    fun processUserIntentDetailPokemon(
        detailtPokemonIntents: Flow<DetailPokemonUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        detailtPokemonIntents
            .flatMapMerge { detailPokemonIntent ->
                processor.actionProcessor(detailPokemonIntent.toAction())
            }
            .scan(loadingUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { detailtPokemonstate ->
                detailtokemonUiState.emit(detailtPokemonstate)
            }
            .flowOn(Dispatchers.IO)
            .distinctUntilChanged()
            .catch { e ->
                e.printStackTrace()
            }
            .launchIn(coroutineScope)
    }

    private fun DetailPokemonUIntent.toAction(): DetailPokemonAction {
        return when (this) {
            is GetDetailPokemonUIntent -> GetDetailPokemonAction(
                this.namePokemon
            )
            is RetryUIntent -> GetDetailPokemonAction(
                this.namePokemon
            )
        }
    }
}