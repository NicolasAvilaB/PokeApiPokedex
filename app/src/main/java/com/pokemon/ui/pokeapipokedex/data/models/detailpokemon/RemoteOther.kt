package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.DREAM_WORLD
import com.pokemon.ui.pokeapipokedex.data.models.Constants.HOME
import com.pokemon.ui.pokeapipokedex.data.models.Constants.OFFICIAL_ARTWORK
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SHOWDOWN

data class RemoteOther(
    @SerializedName(DREAM_WORLD) val dreamworld: RemoteOtherDetail?,
    @SerializedName(HOME) val home: RemoteHome?,
    @SerializedName(OFFICIAL_ARTWORK) val officialartwork: RemoteOfficialArtwork?,
    @SerializedName(SHOWDOWN) val showdown: RemoteShowDown?
)
