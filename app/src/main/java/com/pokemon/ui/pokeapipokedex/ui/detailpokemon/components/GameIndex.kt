package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText16
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText18

@Composable
fun GameIndex(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
){
    Card(
        modifier = Modifier
            .padding(paddingText)
    ) {
        PokemonText18(
            text = "Indice en Juegos",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(paddingText)
        )
        LazyColumn(
            modifier = Modifier
                .width(150.dp)
                .padding(paddingText)
        ) {
            detailPokemon.gameindices?.let { gameindices ->
                items(gameindices.size) { index ->
                    val gameIndex = gameindices[index]
                    gameIndex?.let { gameContent ->
                        PokemonText16(
                            text = "Juego: ${gameContent.version?.name?.capitalize()}"
                        )
                        PokemonText16(
                            text = "Indice: ${gameContent.gameindex}"
                        )
                        Divider(modifier = Modifier.padding(paddingText))
                    }
                }
            }
        }
    }
}