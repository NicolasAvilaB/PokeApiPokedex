package com.pokemon.ui.pokeapipokedex.data.models

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SPRITES

data class RemoteListSpritesPokemon(
    @SerializedName(SPRITES) val sprites: List<RemoteSpritesPokemon?>?
)