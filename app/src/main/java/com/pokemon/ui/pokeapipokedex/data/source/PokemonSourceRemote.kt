package com.pokemon.ui.pokeapipokedex.data.source

import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon

interface PokemonSourceRemote {
    suspend fun getListPokemonRemote(page: Int): RemoteListPokemon
    suspend fun getDetailPokemonRemote(namePokemon: String): RemoteListDetailPokemon
}
