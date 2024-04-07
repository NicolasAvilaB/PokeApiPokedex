package com.testlistdog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.testlistdog.ui.listdogs.di.ListPokemonProvider

@Composable
fun NavController(fragmentActivity: FragmentActivity) {
    val startDestination: String = NavRoutes.ListPokemonScreen.routes
    val navController = rememberNavController()

    val listPokemonProvider = ListPokemonProvider()
    val listPokemonViewModel = listPokemonProvider.getViewModel(fragmentActivity)
    val listPokemonIntentHandler = listPokemonProvider.getIntentHandler()

    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        listPokemon(
            viewModel = listPokemonViewModel,
            intentHandler = listPokemonIntentHandler
        )
        detailPokemon()
    }
}