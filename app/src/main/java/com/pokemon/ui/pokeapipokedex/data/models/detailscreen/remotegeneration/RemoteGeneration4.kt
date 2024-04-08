package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.DIAMOND_PEARL
import com.pokemon.ui.pokeapipokedex.data.models.Constants.HEARTGOLD_SOULSILVER
import com.pokemon.ui.pokeapipokedex.data.models.Constants.PLATINUM
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame.RemoteGame4

data class RemoteGeneration4(
    @SerializedName(DIAMOND_PEARL) val diamondpearl: RemoteGame4?,
    @SerializedName(HEARTGOLD_SOULSILVER) val heartgoldsoulsilver: RemoteGame4?,
    @SerializedName(PLATINUM) val platinum: RemoteGame4?,
)
