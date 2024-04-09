package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText16

@Composable
fun HeaderAbility(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingText)
    ) {
        LazyColumn(
            modifier = Modifier
                .height(100.dp)
                .padding(paddingText)
        ) {
            detailPokemon.abilities?.let { abilities ->
                items(abilities.size) { index ->
                    val ability = abilities[index]
                    ability?.let { ability ->
                        PokemonText16(
                            text = "Habilidad: ${ability.ability?.name?.capitalize()}",
                            fontWeight = FontWeight.Bold
                        )
                        PokemonText16(
                            text = "Slot: ${ability.slot}"
                        )
                        Divider()
                    }
                }
            }
        }
        Button(
            onClick = {
                runCatching {
                    MediaPlayer().apply {
                        reset()
                        setDataSource(detailPokemon.cries?.latest.toString())
                        prepare()
                        start()
                    }
                }.onFailure { e ->
                    e.printStackTrace()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = paddingText,
                    end = paddingText
                )
        ) {
            PokemonText16(text = "Grito Nuevo")
        }
        Button(
            onClick = {
                runCatching {
                    MediaPlayer().apply {
                        reset()
                        setDataSource(detailPokemon.cries?.legacy.toString())
                        prepare()
                        start()
                    }
                }.onFailure { e ->
                    e.printStackTrace()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = paddingText,
                    end = paddingText
                )
        ) {
            PokemonText16(text = "Grito Antiguo")
        }
    }
}