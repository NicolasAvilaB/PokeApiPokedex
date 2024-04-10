package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.ui.navigation.NavGo

@Composable
fun ListPokemon(
    listPokemonItems: RemoteListPokemon,
    number: MutableState<Int>,
    navGo: NavGo
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .fillMaxHeight(0.9f)
    ) {
        TextHeadDescription(
            listPokemonItems = listPokemonItems,
            number = number
        )
        LazyColumn {
            listPokemonItems.results?.let { pokemonList ->
                items(pokemonList.size) { index ->
                    val pokemon = pokemonList[index]
                    pokemon?.let { remotePokemon ->
                        ListSelectItem(
                            name = remotePokemon.name.toString(),
                            onClick = {
                                navGo.logDetailPokemon.invoke(
                                    remotePokemon.name.toString()
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}