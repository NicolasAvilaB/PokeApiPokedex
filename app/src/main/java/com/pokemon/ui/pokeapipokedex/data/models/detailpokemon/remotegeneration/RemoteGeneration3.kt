package com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.remotegeneration

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.EMERALD
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FIRERED_LEAFGREEN
import com.pokemon.ui.pokeapipokedex.data.models.Constants.RUBY_SAPPHIRE
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteOfficialArtwork
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.remotegeneration.remotegame.RemoteGame3

data class RemoteGeneration3(
    @SerializedName(EMERALD) val emerald: RemoteOfficialArtwork?,
    @SerializedName(FIRERED_LEAFGREEN) val fireredleafgreen: RemoteGame3?,
    @SerializedName(RUBY_SAPPHIRE) val rubysapphire: RemoteGame3?,
)
