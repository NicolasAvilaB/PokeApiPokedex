package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ABILITY
import com.pokemon.ui.pokeapipokedex.data.models.Constants.IS_HIDDEN
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SLOT
import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemotePokemon

data class RemoteAbilities (
    @SerializedName(ABILITY) val ability: RemotePokemon?,
    @SerializedName(IS_HIDDEN) val ishidden: Boolean?,
    @SerializedName(SLOT) val slot: Int?
)