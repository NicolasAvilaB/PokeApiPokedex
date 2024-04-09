package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText16
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText18

@Composable
fun TypeTable(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
) {
    Card(
        modifier = Modifier
            .padding(paddingText)
            .fillMaxSize()
    ) {
        PokemonText18(
            text = "Tabla de Tipos",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(paddingText)
        )
        LazyColumn(modifier = Modifier
            .padding(paddingText)) {
            detailPokemon.types?.let { types ->
                items(types.size) { index ->
                    val type = types[index]
                    type?.let { typesName ->
                        PokemonText16(text = "Tipo: ${typesName.type?.name?.capitalize()}")
                        PokemonText16(text = "Slot: ${typesName.slot}")
                        Divider(modifier = Modifier.padding(paddingText))
                    }
                }
            }
        }
    }
}