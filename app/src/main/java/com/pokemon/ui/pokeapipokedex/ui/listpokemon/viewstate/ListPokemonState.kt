package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.components.ListPokemon
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.components.PagesButton
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@Composable
fun ListPokemonState(
    listPokemonItems: RemoteListPokemon,
    intentHandler: ListPokemonIntentHandler,
    number: MutableState<Int>,
    navGo: NavGo,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        ListPokemon(
            listPokemonItems = listPokemonItems,
            number = number,
            navGo = navGo
        )
        PagesButton(
            intentHandler = intentHandler,
            number = number
        )
    }
}
