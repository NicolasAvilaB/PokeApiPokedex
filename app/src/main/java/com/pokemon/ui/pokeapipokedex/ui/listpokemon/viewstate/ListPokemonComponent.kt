package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ListPokemonComponent(
    listPokemonItems: RemoteListPokemon
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp)
    ) {
        listPokemonItems.results?.let { pokemonList ->
            items(pokemonList.size) { index ->
                val pokemon = pokemonList[index]
                pokemon?.let { remotePokemon ->
                    CardItemSection(
                        name = remotePokemon.name.toString(),
                        url = remotePokemon.url.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun CardItemSection(name: String, url: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(url),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(166.dp)
                    .clip(shape = RoundedCornerShape(11.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name.capitalize(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = url,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}