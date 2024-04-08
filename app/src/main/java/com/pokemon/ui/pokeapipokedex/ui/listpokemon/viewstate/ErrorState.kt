package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

@Composable
fun ErrorState(intentHandler: ListPokemonIntentHandler) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.error_message),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Button(
            onClick = {
                intentHandler.pagesPokemon(number = 0)
            }
        ) {
            Text(stringResource(id = R.string.retry))
        }
    }
}