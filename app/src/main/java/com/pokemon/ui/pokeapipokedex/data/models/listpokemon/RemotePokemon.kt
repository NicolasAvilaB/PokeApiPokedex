package com.pokemon.ui.pokeapipokedex.data.models.listpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.NAME
import com.pokemon.ui.pokeapipokedex.data.models.Constants.URL

data class RemotePokemon(
    @SerializedName(NAME) val name: String?,
    @SerializedName(URL) val url: String?,
)