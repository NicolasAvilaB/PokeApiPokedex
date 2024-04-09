package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GAME_INDEX
import com.pokemon.ui.pokeapipokedex.data.models.Constants.VERSION
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemotePokemon

data class RemoteGameIndices (
    @SerializedName(GAME_INDEX) val gameindex: Int?,
    @SerializedName(VERSION) val version: RemotePokemon?
)