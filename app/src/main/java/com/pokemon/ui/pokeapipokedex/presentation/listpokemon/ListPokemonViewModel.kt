package com.pokemon.ui.pokeapipokedex.presentation.listpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction.GetListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIntent.GetListPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIntent.RetryIntent
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

class ListPokemonViewModel(
    private val reducer : ListPokemonReducer,
    private val processor : ListPokemonProcessor
) : ViewModel() {

    val loadingUiState: ListPokemonUIState = LoadingUiState
    private val listPokemonUiState: MutableSharedFlow<ListPokemonUIState> =
        MutableSharedFlow(replay = 1)

    fun pokemonState(): Flow<ListPokemonUIState> =
        listPokemonUiState

    fun processUserIntentsAndObserveUiStates(
        pokemonIntents: Flow<ListPokemonUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        pokemonIntents
            .flatMapMerge { pokemonIntent ->
                processor.actionProcessor(pokemonIntent.toAction())
            }
            .scan(loadingUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { pokemonstate ->
                listPokemonUiState.emit(pokemonstate)
            }
            .flowOn(Dispatchers.IO)
            .distinctUntilChanged()
            .catch { e ->
                e.printStackTrace()
            }
            .launchIn(coroutineScope)
    }

    private fun ListPokemonUIntent.toAction(): ListPokemonAction {
        return when (this) {
            is GetListPokemonUIntent -> GetListPokemonAction(this.number)
            is RetryIntent -> GetListPokemonAction(this.number)
        }
    }
}