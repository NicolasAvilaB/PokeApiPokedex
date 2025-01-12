package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.items.ui.text.ComposesText18
import com.items.ui.text.ComposesText20
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon

@Composable
fun TextHeadDescription(listPokemonItems: RemoteListPokemon, number: MutableState<Int>) {
    ComposesText20(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp),
        text = stringResource(id = R.string.pokemons_total) + " ${listPokemonItems.count}",
    )
    ComposesText18(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        text = stringResource(id = R.string.pokedex_from) + " ${number.value} " +
                stringResource(id = R.string.pokedex_to) + " ${number.value + 20}"
    )
}