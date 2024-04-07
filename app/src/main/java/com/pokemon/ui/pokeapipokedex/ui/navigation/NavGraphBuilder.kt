package com.testlistdog.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pokemon.ui.pokeapipokedex.presentation.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonScreen
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonScreen

internal fun NavGraphBuilder.listPokemon(
    viewModel: ListPokemonViewModel,
    intentHandler: ListPokemonIntentHandler
) = composable(
    route = NavRoutes.ListPokemonScreen.routes
) {
    viewModel.processUserIntentsAndObserveUiStates(
        intentHandler.pokemonUIntents()
    )
    val uiState = remember {
        viewModel.pokemonState()
    }.collectAsState(initial = viewModel.loadingUiState)

    ListPokemonScreen(
        intentHandler = intentHandler,
        uiState = uiState
    )
}

internal fun NavGraphBuilder.detailPokemon(

) = composable(
    route = NavRoutes.DetailPokemonScreen.routes
) {
    DetailPokemonScreen(
    )
}