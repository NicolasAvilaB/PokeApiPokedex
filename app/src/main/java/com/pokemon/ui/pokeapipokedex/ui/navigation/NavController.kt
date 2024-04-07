package com.testlistdog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavController(fragmentActivity: FragmentActivity) {
    val startDestination: String = NavRoutes.ListPokemonScreen.routes
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        listPokemon()
        detailPokemon()
    }
}