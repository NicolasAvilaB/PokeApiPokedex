package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ITEM
import com.pokemon.ui.pokeapipokedex.data.models.Constants.VERSION_DETAILS
import com.pokemon.ui.pokeapipokedex.data.models.RemotePokemon

data class RemoteHeldItems (
    @SerializedName(ITEM) val item: RemotePokemon?,
    @SerializedName(VERSION_DETAILS) val versiondetails: List<RemoteVersionDetail?>?
)