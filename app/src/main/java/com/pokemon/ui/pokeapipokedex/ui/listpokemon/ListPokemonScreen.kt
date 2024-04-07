package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.pokemon.ui.pokeapipokedex.presentation.PokemonUIState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ErrorComponent
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ListPokemonComponent
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.LoadingComponent

@Composable
fun ListPokemonScreen(
    uiState: State<PokemonUIState>,
    intentHandler: ListPokemonIntentHandler
) {
    ListPokemonContent(uiState = uiState, intentHandler = intentHandler)
}

@Composable
fun ListPokemonContent(
    uiState: State<PokemonUIState>,
    intentHandler: ListPokemonIntentHandler
) {
    when (val currentState = uiState.value){
        is PokemonUIState.DisplayListPokemonUiState -> {
            ListPokemonComponent(currentState.listPokemon)
        }
        is PokemonUIState.ErrorUiState -> {
            ErrorComponent(intentHandler = intentHandler)
        }
        PokemonUIState.LoadingUiState -> {
            LoadingComponent()
        }
    }
}