package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

@Composable
fun ListPokemonComponent(
    listPokemonItems: RemoteListPokemon,
    intentHandler: ListPokemonIntentHandler
) {
    val number = remember{ mutableStateOf(0)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(18.dp)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "N° de Pokemons: ${listPokemonItems.count}",
                fontSize = 20.sp,
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    number.value += 20
                    intentHandler.nextPagePokemon(number = number.value)
                },
            ){
                Text("Siguiente")
            }
        }

        LazyColumn {
            listPokemonItems.results?.let { pokemonList ->
                items(pokemonList.size) { index ->
                    val pokemon = pokemonList[index]
                    pokemon?.let { remotePokemon ->
                        ItemSection(
                            name = remotePokemon.name.toString(),
                            onClick = {
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ItemSection(name: String, onClick: () -> Unit) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(paddingRow)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name.capitalize(),
                fontSize = 20.sp,
            )
        }
        Divider(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
}

private val paddingRow = 16.dp