package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ICONS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ULTRA_SUN_ULTRA_MOON
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.RemoteHome
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame.RemoteGameIcons7

data class RemoteGeneration7(
    @SerializedName(ICONS) val icons: RemoteGameIcons7?,
    @SerializedName(ULTRA_SUN_ULTRA_MOON) val ultrasunultramoon: RemoteHome?
)
