package com.pokemon.ui.pokeapipokedex.data.remote.retrofit

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import retrofit2.http.GET

internal interface ListPokemonWebService {
    @GET("api/v2/pokemon")
    suspend fun getListPokemon(): RemoteListPokemon
}
