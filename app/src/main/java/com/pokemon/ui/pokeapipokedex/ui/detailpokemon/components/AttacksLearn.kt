package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun AttacksLearn(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
){
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(paddingText)
    ) {
        PokemonText18(
            text = "Aprendizaje Ataque",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(paddingText)
        )
        LazyColumn(modifier = Modifier.height(170.dp).padding(paddingText)) {
            detailPokemon.moves?.let { moves ->
                moves.forEach { move ->
                    move?.let { move ->
                        item {
                            Divider(
                                thickness = paddingText
                            )
                            PokemonText16(
                                text = "Ataque: ${move.move?.name?.capitalize()}",
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        move.versiongroupdetails?.forEach { detail ->
                            detail?.let { detail ->
                                item {
                                    PokemonText16(text = "Nivel Apr.: ${detail.levellearnedat}")
                                    PokemonText16(text = "Método: ${detail.movelearnmethod?.name}")
                                    PokemonText16(text = "Versión: ${detail.versiongroup?.name}")
                                    Divider()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}