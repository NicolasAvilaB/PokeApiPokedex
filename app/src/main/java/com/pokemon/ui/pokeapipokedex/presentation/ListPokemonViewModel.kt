package com.pokemon.ui.pokeapipokedex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.presentation.PokemonAction.GetListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIntent.GetListPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

class ListPokemonViewModel(
    private val reducer : PokemonReducer,
    private val processor : PokemonProcessor
) : ViewModel() {

    fun pokemonUiState(): StateFlow<PokemonUIState> = pokemonUiState
    val pokemonDisplayUiState: PokemonUIState =
        PokemonUIState.DisplayListPokemonUiState(RemoteListPokemon)
    private val pokemonUiState: MutableStateFlow<PokemonUIState> =
        MutableStateFlow(pokemonDisplayUiState)

    fun processUserIntentsAndObserveUiStates(
        pokemonIntents: Flow<PokemonUIntent>,
        coroutineScope: CoroutineScope = viewModelScope,
    ) {
        pokemonIntents.buffer()
            .flatMapMerge { pokemonIntent ->
                processor.actionProcessor(pokemonIntent.toAction())
            }
            .scan(pokemonDisplayUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }
            .onEach { pokemonstate ->
                pokemonUiState.value = pokemonstate
            }
            .launchIn(coroutineScope)
    }

    private fun PokemonUIntent.toAction(): PokemonAction {
        return when (this) {
            is GetListPokemonUIntent -> GetListPokemonAction
        }
    }
}