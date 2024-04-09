package com.pokemon.ui.pokeapipokedex.data.remote

import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.PokemonWebService
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote

internal class PokemonRemoteImpl(
    private val webService: PokemonWebService
) : PokemonSourceRemote {
    
    override suspend fun getListPokemonRemote(page: Int): RemoteListPokemon =
        webService.getListPokemon(page)

    override suspend fun getDetailPokemonRemote(namePokemon: String): RemoteListDetailPokemon =
        webService.getDetailPokemon(namePokemon)
}