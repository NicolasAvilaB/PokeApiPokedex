package com.pokemon.ui.pokeapipokedex.presentation.listpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction.GetListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIntent
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIntent.GetListPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan
import okhttp3.Dispatcher

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
            .distinctUntilChanged()
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
            .launchIn(coroutineScope)
    }

    private fun ListPokemonUIntent.toAction(): ListPokemonAction {
        return when (this) {
            is GetListPokemonUIntent -> GetListPokemonAction(this.number)
        }
    }
}