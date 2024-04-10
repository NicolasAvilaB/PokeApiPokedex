package com.pokemon.ui.pokeapipokedex.ui.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.testlistdog.ui.navigation.NAME_POKEMON
import com.testlistdog.ui.navigation.NavRoutes

class NavGo(
    navHostController: NavHostController
) {
    val logDetailPokemon: (String) -> Unit = { namePokemon ->
        navHostController.currentBackStackEntry?.savedStateHandle?.set(
            NAME_POKEMON, namePokemon
        )
        navHostController.navigate(NavRoutes.DetailPokemonScreen.routes)
    }

    val popBackStack: () -> Unit = {
        navHostController.popBackStack()
    }
}