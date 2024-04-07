package com.testlistdog.ui.navigation

sealed class NavRoutes(var routes: String){
    object ListPokemonScreen: NavRoutes("ListPokemonScreen")
    object DetailPokemonScreen: NavRoutes("DetailPokemonScreen")
}
