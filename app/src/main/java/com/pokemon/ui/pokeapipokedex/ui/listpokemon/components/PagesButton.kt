package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

@Composable
fun PagesButton(
    listPokemonItems: RemoteListPokemon,
    intentHandler: ListPokemonIntentHandler,
    number: MutableState<Int>,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            enabled = number.value != 0,
            onClick = {
                kotlin.runCatching {
                    number.value -= 20
                    intentHandler.pagesPokemon(number = number.value)
                }.onFailure { e ->
                    e.printStackTrace()
                }
            },
        ) {
            Text(
                stringResource(id = R.string.page_back)
            )
        }
        Button(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            enabled = number.value + 20 <= listPokemonItems.count!!,
            onClick = {
                kotlin.runCatching {
                    number.value += 20
                    intentHandler.pagesPokemon(number = number.value)
                }.onFailure { e ->
                    e.printStackTrace()
                }
            },
        ) {
            Text(
                stringResource(id = R.string.page_next)
            )
        }
    }
}