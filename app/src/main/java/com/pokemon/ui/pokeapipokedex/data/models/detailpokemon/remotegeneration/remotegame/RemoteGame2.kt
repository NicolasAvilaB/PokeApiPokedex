package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.remotegeneration.remotegame

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_SHINY_TRANSPARENT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_TRANSPARENT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY_TRANSPARENT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_TRANSPARENT

data class RemoteGame2(
    @SerializedName(BACK_DEFAULT) val backdefault: String?,
    @SerializedName(BACK_SHINY) val backshiny: String?,
    @SerializedName(BACK_SHINY_TRANSPARENT) val backshinytransparent: String?,
    @SerializedName(BACK_TRANSPARENT) val backtransparent: String?,
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_SHINY) val frontshiny: String?,
    @SerializedName(FRONT_SHINY_TRANSPARENT) val frontshinytransparent: String?,
    @SerializedName(FRONT_TRANSPARENT) val fronttransparent: String?
)