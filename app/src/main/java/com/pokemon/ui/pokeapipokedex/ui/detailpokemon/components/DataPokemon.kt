package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun DataPokemon(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
) {
    Card(
        modifier = Modifier
            .padding(paddingText)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(paddingText)
        ) {
            PokemonText18(
                text = "Datos Pokémon",
                fontWeight = FontWeight.Bold,
            )
            PokemonText16(
                text = "N° Pokedex: ${detailPokemon.id}"
            )
            PokemonText16(
                text = "Experiencia Base: ${detailPokemon.baseexperience}"
            )
            PokemonText16(text = "Altura: ${detailPokemon.height}")
            PokemonText16(
                text = "Orden: ${detailPokemon.order}"
            )
            PokemonText16(
                text = "Peso: ${detailPokemon.weight}"
            )
        }
        Divider(modifier = Modifier.padding(paddingText))
    }
}