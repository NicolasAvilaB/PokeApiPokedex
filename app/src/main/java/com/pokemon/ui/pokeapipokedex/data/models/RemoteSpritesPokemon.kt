package com.pokemon.ui.pokeapipokedex.data.models

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FRONT_DEFAULT

data class RemoteSpritesPokemon(
    @SerializedName(FRONT_DEFAULT) val front_default: String?
)
