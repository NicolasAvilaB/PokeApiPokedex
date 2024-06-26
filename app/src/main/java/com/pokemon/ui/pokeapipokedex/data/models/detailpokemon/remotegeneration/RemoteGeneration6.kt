package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.OMEGARUBY_ALPHASAPPHIRE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.X_Y
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteHome

data class RemoteGeneration6(
    @SerializedName(OMEGARUBY_ALPHASAPPHIRE) val omegarubyalphasapphire: RemoteHome?,
    @SerializedName(X_Y) val xy: RemoteHome?
)
