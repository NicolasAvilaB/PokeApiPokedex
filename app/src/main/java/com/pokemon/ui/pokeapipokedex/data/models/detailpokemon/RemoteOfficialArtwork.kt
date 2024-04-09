package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY

data class RemoteOfficialArtwork(
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_SHINY) val frontshiny: String?
)
