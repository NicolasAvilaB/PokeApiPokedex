package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.remotegeneration.remotegame

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY

data class RemoteGame3(
    @SerializedName(BACK_DEFAULT) val backdefault: String?,
    @SerializedName(BACK_SHINY) val backshiny: String?,
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_SHINY) val frontshiny: String?,
)