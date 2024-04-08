package com.pokemon.ui.pokeapipokedex.data.remote

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListSpritesPokemon
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.ListPokemonWebService
import com.pokemon.ui.pokeapipokedex.data.source.ListPokemonSourceRemote

internal class ListPokemonRemoteImpl(
    private val webService: ListPokemonWebService
) : ListPokemonSourceRemote {
    
    override suspend fun getListPokemonRemote(page: Int): RemoteListPokemon =
        webService.getListPokemon(page)

    override suspend fun getImagePokemonRemote(namePokemon: String): RemoteListSpritesPokemon =
        webService.getImagePokemon(namePokemon)
}