package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.RED_BLUE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.YELLOW
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame.RemoteGame1

data class RemoteGeneration1(
    @SerializedName(RED_BLUE) val redblue: RemoteGame1?,
    @SerializedName(YELLOW) val yellow: RemoteGame1?
)
