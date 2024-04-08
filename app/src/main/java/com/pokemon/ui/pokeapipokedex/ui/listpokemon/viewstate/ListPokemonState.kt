package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.components.ListSelectItem
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.components.PagesButton
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.components.TextHeadDescription

@Composable
fun ListPokemonState(
    listPokemonItems: RemoteListPokemon,
    intentHandler: ListPokemonIntentHandler,
    number: MutableState<Int>
) {
    Column {
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
                                }
                            )
                        }
                    }
                }
            }
        }
        PagesButton(
            intentHandler = intentHandler,
            number = number
        )
    }
}
