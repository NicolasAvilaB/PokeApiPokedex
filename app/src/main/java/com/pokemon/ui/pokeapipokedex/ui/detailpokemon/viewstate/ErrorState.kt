package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@Composable
fun ErrorState(navGo: NavGo) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.error_message),
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
            Button(
                onClick = {
                    navGo.popBackStack.invoke()
                }
            ) {
                Text(stringResource(id = R.string.retry))
            }
        }
    }
}