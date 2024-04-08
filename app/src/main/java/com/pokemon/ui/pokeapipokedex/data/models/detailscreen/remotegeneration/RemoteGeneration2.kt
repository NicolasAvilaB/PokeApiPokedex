package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.CRYSTAL
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GOLD
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SILVER
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame.RemoteGame2

data class RemoteGeneration2(
    @SerializedName(CRYSTAL) val crystal: RemoteGame2?,
    @SerializedName(GOLD) val gold: RemoteGame2?,
    @SerializedName(SILVER) val silver: RemoteGame2?,
)
