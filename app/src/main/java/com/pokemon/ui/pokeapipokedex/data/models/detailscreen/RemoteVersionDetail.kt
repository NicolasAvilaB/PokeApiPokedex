package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.RARITY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.VERSION
import com.pokemon.ui.pokeapipokedex.data.models.RemotePokemon

data class RemoteVersionDetail (
    @SerializedName(RARITY) val rarity: Int?,
    @SerializedName(VERSION) val version: RemotePokemon?,
)