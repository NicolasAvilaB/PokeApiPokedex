package com.testlistdog.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonViewModel
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonScreen
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonScreen
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.listPokemon(
    viewModel: ListPokemonViewModel,
    intentHandler: ListPokemonIntentHandler,
    navGo: NavGo
) = composable(
    route = NavRoutes.ListPokemonScreen.routes
) {
    LaunchedEffect(key1 = viewModel) {
        viewModel.processUserIntentsAndObserveUiStates(intentHandler.pokemonUIntents())
    }
    val listPokemonIntentHandler = intentHandler.apply {
        coroutineScope = rememberCoroutineScope()
    }
    val uiState = remember {
        viewModel.pokemonState()
    }.collectAsState(initial = viewModel.loadingUiState)

    ListPokemonScreen(
        intentHandler = listPokemonIntentHandler,
        uiState = uiState,
        navGo = navGo
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoroutinesApi::class)
internal fun NavGraphBuilder.detailPokemon(
    intentHandler: DetailPokemonIntentHandler,
    viewModel: DetailPokemonViewModel,
    navController: NavHostController,
    navGo: NavGo
) = composable(
    route = NavRoutes.DetailPokemonScreen.routes,
) {
    navController.previousBackStackEntry?.savedStateHandle?.get<String>(
        NAME_POKEMON
    )?.let { namePokemon ->
        LaunchedEffect(key1 = viewModel) {
            viewModel.processUserIntentDetailPokemon(
                intentHandler.detailPokemonUIntents(namePokemon = namePokemon)
            )
        }
        val detailPokemonIntentHandler = intentHandler.apply {
            coroutineScope = rememberCoroutineScope()
        }
        val uiState = remember {
            viewModel.detailViewPokemonState()
        }.collectAsState(initial = viewModel.loadingUiState)

        DetailPokemonScreen(
            intentHandler = detailPokemonIntentHandler,
            namePokemon = namePokemon,
            uiState = uiState,
            navGo = navGo
        )
    }
}

const val NAME_POKEMON = "namePokemon"