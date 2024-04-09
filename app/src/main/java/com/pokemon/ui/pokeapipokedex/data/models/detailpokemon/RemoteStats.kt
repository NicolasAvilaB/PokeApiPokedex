package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BASE_STAT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.EFFORT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.STAT
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemotePokemon

data class RemoteStats(
    @SerializedName(BASE_STAT) val basestat: Int?,
    @SerializedName(EFFORT) val effort: Int?,
    @SerializedName(STAT) val stat: RemotePokemon?
)
