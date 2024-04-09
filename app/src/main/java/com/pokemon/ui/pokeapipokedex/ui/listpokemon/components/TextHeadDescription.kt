package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon

@Composable
fun TextHeadDescription(listPokemonItems: RemoteListPokemon, number: MutableState<Int>) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp),
        text =
        stringResource(id = R.string.pokemons_total) + " ${listPokemonItems.count}",
        fontSize = 20.sp,
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        text = stringResource(id = R.string.pokedex_from) + " ${number.value} " +
                stringResource(id = R.string.pokedex_to) + " ${number.value + 20}"
    )
}