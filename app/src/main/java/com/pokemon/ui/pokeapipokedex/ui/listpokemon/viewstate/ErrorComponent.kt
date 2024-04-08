package com.pokemon.ui.pokeapipokedex.ui.listpokemon.viewstate

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

@Composable
fun ErrorComponent(intentHandler: ListPokemonIntentHandler){
    Button(onClick = { intentHandler.pokemonUIntents(number = 0)}) {
        Text("Reintentar")
    }
}