package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ANIMATED
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_FEMALE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_SHINY_FEMALE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_FEMALE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_SHINY_FEMALE

data class RemoteGame5(
    @SerializedName(ANIMATED) val animated: RemoteGame5Animated?,
    @SerializedName(BACK_DEFAULT) val backdefault: String?,
    @SerializedName(BACK_FEMALE) val backfemale: String?,
    @SerializedName(BACK_SHINY) val backshiny: String?,
    @SerializedName(BACK_SHINY_FEMALE) val backshinyfemale: String?,
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_FEMALE) val frontfemale: String?,
    @SerializedName(FRONT_SHINY) val frontshiny: String?,
    @SerializedName(FRONT_SHINY_FEMALE) val frontshinyfemale: String?,
)