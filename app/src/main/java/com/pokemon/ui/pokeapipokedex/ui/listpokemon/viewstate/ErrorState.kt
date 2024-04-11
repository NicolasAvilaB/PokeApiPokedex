package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.ImagePokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText24
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.theme.RedStrong

@Composable
fun ErrorState(
    intentHandler: ListPokemonIntentHandler,
    number: MutableState<Int>
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImagePokemon(
                painter = painterResource(id = R.drawable.ui_pikachu_image)
            )
            PokemonText24(
                text = stringResource(id = R.string.error_message),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(24.dp),
            )
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedStrong
                ),
                onClick = {
                    number.value = 0
                    intentHandler.retryIntent(number = number.value)
                }
            ) {
                Text(stringResource(id = R.string.retry))
            }
        }
    }
}