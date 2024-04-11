package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.DisplayListPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ErrorState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.ListPokemonState
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate.LoadingState
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPokemonScreen(
    uiState: State<ListPokemonUIState>,
    intentHandler: ListPokemonIntentHandler,
    navGo: NavGo
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(id = R.string.pokedex_title))
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),

            )
        }
    ) { paddingValues ->
        ListPokemonContent(
            uiState = uiState,
            intentHandler = intentHandler,
            navGo = navGo,
            paddingValues = paddingValues
        )
    }
}

@Composable
fun ListPokemonContent(
    uiState: State<ListPokemonUIState>,
    intentHandler: ListPokemonIntentHandler,
    navGo: NavGo,
    paddingValues: PaddingValues
) {
    val number = remember { mutableStateOf(0) }

    when (val currentState = uiState.value){
        is DisplayListPokemonUiState -> {
            ListPokemonState(
                listPokemonItems = currentState.listPokemon,
                intentHandler = intentHandler,
                navGo = navGo,
                number = number,
                paddingValues = paddingValues
            )
        }
        is ErrorUiState -> {
            ErrorState(intentHandler = intentHandler, number = number)
        }
        LoadingUiState -> {
            LoadingState()
        }
    }
}