package com.pokemon.ui.pokeapipokedex.data.source

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.RemoteListDetailPokemon

interface ListPokemonSourceRemote {
    suspend fun getListPokemonRemote(page: Int): RemoteListPokemon
    suspend fun getImagePokemonRemote(namePokemon: String): RemoteListDetailPokemon
}
