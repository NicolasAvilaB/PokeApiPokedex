package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_I
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_II
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_III
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_IV
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_V
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_VI
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_VII
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GENERATION_VIII
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration1
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration2
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration3
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration4
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration5
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration6
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration7
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.remotegeneration.RemoteGeneration8

data class RemoteVersions(
    @SerializedName(GENERATION_I) val generationi: RemoteGeneration1?,
    @SerializedName(GENERATION_II) val generationii: RemoteGeneration2?,
    @SerializedName(GENERATION_III) val generationiii: RemoteGeneration3?,
    @SerializedName(GENERATION_IV) val generationiv: RemoteGeneration4?,
    @SerializedName(GENERATION_V) val generationv: RemoteGeneration5?,
    @SerializedName(GENERATION_VI) val generationvi: RemoteGeneration6?,
    @SerializedName(GENERATION_VII) val generationvii: RemoteGeneration7?,
    @SerializedName(GENERATION_VIII) val generationviii: RemoteGeneration8?
)
