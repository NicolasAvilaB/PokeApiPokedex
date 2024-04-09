package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SLOT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.TYPE
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemotePokemon

data class RemoteType(
    @SerializedName(SLOT) val slot: Int?,
    @SerializedName(TYPE) val type: RemotePokemon?
)
