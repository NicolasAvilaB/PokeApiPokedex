package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.LEVEL_LEARNED_AT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.MOVE_LEARN_METHOD
import com.pokemon.ui.pokeapipokedex.data.models.Constants.VERSION_GROUP
import com.pokemon.ui.pokeapipokedex.data.models.RemotePokemon

data class RemoteVersionGroupDetail (
    @SerializedName(LEVEL_LEARNED_AT) val levellearnedat: Int?,
    @SerializedName(MOVE_LEARN_METHOD) val movelearnmethod: RemotePokemon?,
    @SerializedName(VERSION_GROUP) val versiongroup: RemotePokemon?
)