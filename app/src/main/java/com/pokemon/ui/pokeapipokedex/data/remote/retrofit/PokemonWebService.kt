package com.pokemon.ui.pokeapipokedex.data.remote.retrofit

import com.pokemon.ui.pokeapipokedex.data.models.Constants.LIMIT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.NAME_POKEMON
import com.pokemon.ui.pokeapipokedex.data.models.Constants.OFFSET
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface PokemonWebService {
    @GET("api/v2/pokemon")
    suspend fun getListPokemon(
        @Query(OFFSET) page: Int,
        @Query(LIMIT) limit: Int = 20
    ): RemoteListPokemon

    @GET("api/v2/pokemon/{namePokemon}")
    suspend fun getDetailPokemon(
        @Path(NAME_POKEMON) namePokemon: String
    ): RemoteListDetailPokemon
}
