package com.testlistdog.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonScreen
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonScreen

internal fun NavGraphBuilder.listPokemon(

) = composable(
    route = NavRoutes.ListPokemonScreen.routes
) {
    ListPokemonScreen(
    )
}

internal fun NavGraphBuilder.detailPokemon(

) = composable(
    route = NavRoutes.DetailPokemonScreen.routes
) {
    DetailPokemonScreen(
    )
}