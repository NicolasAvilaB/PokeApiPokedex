package com.testlistdog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.di.DetailPokemonProvider
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo
import com.testlistdog.ui.listdogs.di.ListPokemonProvider

@Composable
fun NavController(fragmentActivity: FragmentActivity) {
    val startDestination: String = NavRoutes.ListPokemonScreen.routes

    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController) }

    val detailPokemonProvider = DetailPokemonProvider()
    val detailPokemonViewModel = detailPokemonProvider.getViewModel(fragmentActivity)
    val detailPokemonIntentHandler = detailPokemonProvider.getIntentHandler().apply {
        this.coroutineScope = rememberCoroutineScope()
    }

    val listPokemonProvider = ListPokemonProvider()
    val listPokemonViewModel = listPokemonProvider.getViewModel(fragmentActivity)
    val listPokemonIntentHandler = listPokemonProvider.getIntentHandler().apply {
        this.coroutineScope = rememberCoroutineScope()
    }

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