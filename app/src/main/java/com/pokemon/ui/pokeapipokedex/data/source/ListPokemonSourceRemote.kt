package com.pokemon.ui.pokeapipokedex.data.source

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon

interface ListPokemonSourceRemote {
    suspend fun getListPokemonRemote(): RemoteListPokemon
}
