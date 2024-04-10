package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.spritelistgeneration

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.ImagePokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText18

@Composable
fun ListGeneration1(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
) {
    val generation = detailPokemon.sprites?.versions?.generationi
    if (generation?.redblue?.backdefault != null)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingText)
        ) {
            PokemonText18(
                text = "Sprites de ${detailPokemon.name?.capitalize()} - 1° Gen (RBY)",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(paddingText)
            )
            LazyRow(
                modifier = Modifier
                    .height(150.dp)
                    .padding(paddingText)
            ) {
                generation.redblue?.let { sprite ->
                    sprite.javaClass.declaredFields.forEach { field ->
                        field.isAccessible = true
                        val url = field.get(sprite) as? String
                        url?.let { result ->
                            item {
                                ImagePokemon(
                                    painter = rememberAsyncImagePainter(result)
                                )
                            }
                        }
                    }
                }
                generation.yellow?.let { sprite ->
                    sprite.javaClass.declaredFields.forEach { field ->
                        field.isAccessible = true
                        val url = field.get(sprite) as? String
                        url?.let { result ->
                            item {
                                ImagePokemon(
                                    painter = rememberAsyncImagePainter(result)
                                )
                            }
                        }
                    }
                }
            }
        }
}
