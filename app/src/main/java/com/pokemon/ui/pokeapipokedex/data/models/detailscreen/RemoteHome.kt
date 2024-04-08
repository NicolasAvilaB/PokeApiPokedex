package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_FEMALE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY_FEMALE

data class RemoteHome(
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_FEMALE) val frontfemale: String?,
    @SerializedName(FRONT_SHINY) val frontshiny: String?,
    @SerializedName(FRONT_SHINY_FEMALE) val frontshinyfemale: String?
)
