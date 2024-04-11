package com.testlistdog.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonViewModel
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavController(
    listPokemonViewModel: ListPokemonViewModel,
    listPokemonIntentHandler: ListPokemonIntentHandler,
    detailPokemonViewModel: DetailPokemonViewModel,
    detailPokemonIntentHandler: DetailPokemonIntentHandler
) {
    val startDestination: String = NavRoutes.ListPokemonScreen.routes

    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        listPokemon(
            viewModel = listPokemonViewModel,
            intentHandler = listPokemonIntentHandler,
            navGo = navGo
        )
        detailPokemon(
            viewModel = detailPokemonViewModel,
            intentHandler = detailPokemonIntentHandler,
            navGo = navGo,
            navController = navController
        )
    }
}