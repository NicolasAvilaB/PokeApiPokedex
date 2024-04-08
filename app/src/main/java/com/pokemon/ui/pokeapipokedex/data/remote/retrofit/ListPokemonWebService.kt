package com.pokemon.ui.pokeapipokedex.data.remote.retrofit

import com.pokemon.ui.pokeapipokedex.data.models.Constants.LIMIT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.NAME_POKEMON
import com.pokemon.ui.pokeapipokedex.data.models.Constants.OFFSET
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.RemoteListDetailPokemon
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

internal interface ListPokemonWebService {
    @GET("api/v2/pokemon")
    suspend fun getListPokemon(
        @Query(OFFSET) page: Int,
        @Query(LIMIT) limit: Int = 20
    ): RemoteListPokemon

    @PUT("api/v2/pokemon")
    suspend fun getDetailPokemon(
        @Query(NAME_POKEMON) namePokemon: String,
    ): RemoteListDetailPokemon
}
