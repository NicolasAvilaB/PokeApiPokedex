package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.MOVE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.VERSION_GROUP_DETAILS
import com.pokemon.ui.pokeapipokedex.data.models.RemotePokemon

data class RemoteMoves(
    @SerializedName(MOVE) val move: RemotePokemon?,
    @SerializedName(VERSION_GROUP_DETAILS) val versiongroupdetails: List<RemoteVersionGroupDetail?>?
)