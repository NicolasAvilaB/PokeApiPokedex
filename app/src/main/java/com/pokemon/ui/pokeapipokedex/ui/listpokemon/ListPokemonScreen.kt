package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.DisplayListPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ErrorState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ListPokemonState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.LoadingState

@Composable
fun ListPokemonScreen(
    uiState: State<PokemonUIState>,
    intentHandler: ListPokemonIntentHandler,
) {
    val number = rememberSaveable { mutableStateOf(0) }
    ListPokemonContent(
        uiState = uiState,
        intentHandler = intentHandler,
        number = number
    )
}

@Composable
fun ListPokemonContent(
    uiState: State<PokemonUIState>,
    intentHandler: ListPokemonIntentHandler,
    number: MutableState<Int>
) {
    when (val currentState = uiState.value){
        is DisplayListPokemonUiState -> {
            ListPokemonState(
                listPokemonItems = currentState.listPokemon,
                intentHandler = intentHandler,
                number = number
            )
        }
        is ErrorUiState -> {
            ErrorState(intentHandler = intentHandler)
        }
        LoadingUiState -> {
            LoadingState()
        }
    }
}