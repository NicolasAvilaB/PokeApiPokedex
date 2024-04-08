package com.pokemon.ui.pokeapipokedex.data.remote.retrofit

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListSpritesPokemon
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ListPokemonWebService {
    @GET("api/v2/pokemon")
    suspend fun getListPokemon(
        @Query("offset") page: Int,
        @Query("limit") limit: Int = 20
    ): RemoteListPokemon

    @PUT("api/v2/pokemon/{name_pokemon}")
    suspend fun getImagePokemon(
        @Path("name_pokemon") namePokemon: String
    ): RemoteListSpritesPokemon
}
