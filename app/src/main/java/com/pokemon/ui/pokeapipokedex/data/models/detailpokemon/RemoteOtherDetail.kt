package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_FEMALE

data class RemoteOtherDetail(
    @SerializedName(FRONT_DEFAULT) val front_default: String?,
    @SerializedName(FRONT_FEMALE) val front_female: String?
)
