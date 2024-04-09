package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon

@Composable
fun DetailPokemonState(
    detailPokemon: RemoteListDetailPokemon,
    paddingValues: PaddingValues
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Row {
            Card(
                modifier = Modifier
                    .padding(6.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            detailPokemon.sprites.let { remoteSprites ->
                                remoteSprites?.frontdefault.toString()
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(shape = RoundedCornerShape(11.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "${detailPokemon.name?.capitalize()}",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }
            }
            Column {
                LazyColumn {
                    detailPokemon.abilities?.let { abilities ->
                        items(abilities.size) { index ->
                            val ability = abilities[index]
                            ability?.let { ability ->
                                Text(
                                    text = "Habilidad: ${ability.ability?.name?.capitalize()}"
                                )
                                Text(
                                    text = "Slot: ${ability.slot}"
                                )
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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Grito Nuevo")
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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Grito Antiguo")
                }
            }
        }
        Row {
            LazyColumn(
                modifier = Modifier.size(170.dp)
            ) {
                detailPokemon.gameindices?.let { gameindices ->
                    items(gameindices.size) { index ->
                        val gameIndex = gameindices[index]
                        gameIndex?.let { gameContent ->
                            Text(
                                text = "Juego: ${gameContent.version?.name?.capitalize()}"
                            )
                            Text(
                                text = "N° (Pokédex): ${gameContent.gameindex}"
                            )
                        }
                    }
                }
            }
            Column {
                Text(
                    text = "ID: ${detailPokemon.id}"
                )
                Text(
                    text = "Experiencia Base: ${detailPokemon.baseexperience}"
                )
                Text(text = "Altura: ${detailPokemon.height}")
                Text(
                    text = "Orden: ${detailPokemon.order}"
                )
                Text(
                    text = "Peso: ${detailPokemon.weight}"
                )
                LazyColumn {
                    detailPokemon.types?.let { types ->
                        items(types.size) { index ->
                            val type = types[index]
                            type?.let { typesName ->
                                Text(
                                    text = "Slot: ${typesName.slot}"
                                )
                                Text(
                                    text = "Tipo: ${typesName.type?.name?.capitalize()}"
                                )
                            }
                        }
                    }
                }
            }
        }
        LazyColumn(modifier = Modifier.size(170.dp)) {
            detailPokemon.stats?.let { stat ->
                items(stat.size) { index ->
                    val stats = stat[index]
                    stats?.let { stats ->
                        Text(
                            text = "Tipo: ${stats.stat?.name?.capitalize()}"
                        )
                        Text(
                            text = "Base: ${stats.basestat}"
                        )
                        Text(
                            text = "Esfuerzo: ${stats.effort}"
                        )
                    }
                }
            }
        }
    }
}