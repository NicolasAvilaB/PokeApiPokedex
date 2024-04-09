package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun StatsBase(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
){
    Card(
        modifier = Modifier
            .padding(paddingText)
    ) {
        PokemonText18(
            text = "Stats Base",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(paddingText)
        )
        LazyColumn(
            modifier = Modifier
                .size(170.dp)
                .padding(paddingText)
        ) {
            detailPokemon.stats?.let { stat ->
                items(stat.size) { index ->
                    val stats = stat[index]
                    stats?.let { stats ->
                        PokemonText16(text = "Tipo: ${stats.stat?.name?.capitalize()}")
                        PokemonText16(text = "Base: ${stats.basestat}")
                        PokemonText16(text = "Esfuerzo: ${stats.effort}")
                        Divider(modifier = Modifier.padding(paddingText))
                    }
                }
            }
        }
    }
}