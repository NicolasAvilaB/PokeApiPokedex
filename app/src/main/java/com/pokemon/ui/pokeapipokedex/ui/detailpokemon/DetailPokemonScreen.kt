package com.pokemon.ui.pokeapipokedex.ui.detailpokemon

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.DisplayDetailPokemonUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.ErrorUiState
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.events.DetailPokemonUIState.LoadingUiState
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate.DetailPokemonState
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate.ErrorState
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate.LoadingState
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPokemonScreen(
    uiState: State<DetailPokemonUIState>,
    navGo: NavGo
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(id = R.string.detail_pokemon_title))
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                navigationIcon = {
                    IconButton(onClick = { navGo.popBackStack.invoke() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(
                                id = R.string.button_back_description
                            ),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        DetailPokemonContent(
            uiState = uiState,
            navGo = navGo,
            paddingValues = paddingValues
        )
    }

}

@Composable
fun DetailPokemonContent(
    uiState: State<DetailPokemonUIState>,
    navGo: NavGo,
    paddingValues: PaddingValues,
) {
    when (val currentState = uiState.value) {
        is DisplayDetailPokemonUiState -> {
            DetailPokemonState(
                detailPokemon = currentState.detailPokemon,
                paddingValues = paddingValues
            )
        }

        is ErrorUiState -> ErrorState(navGo = navGo)
        LoadingUiState -> LoadingState()
    }
}