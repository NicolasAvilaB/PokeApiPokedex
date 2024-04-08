package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BLACK_WHITE
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame.RemoteGame5

data class RemoteGeneration5(
    @SerializedName(BLACK_WHITE) val blackwhite: RemoteGame5?,
)
