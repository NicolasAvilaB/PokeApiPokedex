package com.pokemon.ui.pokeapipokedex.data.models

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.COUNT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.NEXT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.PREVIOUS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.RESULTS

data class RemoteListPokemon(
    @SerializedName(COUNT) val count: Int,
    @SerializedName(NEXT) val next: String,
    @SerializedName(PREVIOUS) val previous: String,
    @SerializedName(RESULTS) val results: List<RemotePokemon>,
)