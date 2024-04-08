package com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.remotegame

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_FEMALE

data class RemoteGameIcons7(
    @SerializedName(FRONT_DEFAULT) val frontdefault: String?,
    @SerializedName(FRONT_FEMALE) val frontfemale: String?,
)