package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.LATEST
import com.pokemon.ui.pokeapipokedex.data.models.Constants.LEGACY

data class RemoteCries (
    @SerializedName(LATEST) val latest: String?,
    @SerializedName(LEGACY) val legacy: String?
)