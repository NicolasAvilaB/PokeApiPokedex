package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_GRAY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BACK_TRANSPARENT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_GRAY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_TRANSPARENT

data class RemoteGame1(
    @SerializedName(BACK_DEFAULT) val backdefault: String?,
    @SerializedName(BACK_GRAY) val backgray: String?,
    @SerializedName(BACK_TRANSPARENT) val backtransparent: String?,
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_GRAY) val frontgray: String?,
    @SerializedName(FRONT_TRANSPARENT) val fronttransparent: String?
)