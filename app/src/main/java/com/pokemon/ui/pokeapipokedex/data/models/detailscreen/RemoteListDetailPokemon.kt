package com.pokemon.ui.pokeapipokedex.data.models.detailscreen

import com.google.gson.annotations.SerializedName
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ABILITIES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.BASE_EXPERIENCE
import com.pokemon.ui.pokeapipokedex.data.models.Constants.CRIES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.FORMS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.GAME_INDICES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.HEIGHT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.HELD_ITEMS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ID
import com.pokemon.ui.pokeapipokedex.data.models.Constants.IS_DEFAULT
import com.pokemon.ui.pokeapipokedex.data.models.Constants.LOCATION_AREA_ENCOUNTERS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.MOVES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.NAME
import com.pokemon.ui.pokeapipokedex.data.models.Constants.ORDER
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SPECIES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.SPRITES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.STATS
import com.pokemon.ui.pokeapipokedex.data.models.Constants.TYPES
import com.pokemon.ui.pokeapipokedex.data.models.Constants.WEIGHT
import com.pokemon.ui.pokeapipokedex.data.models.RemotePokemon

data class RemoteListDetailPokemon(
    @SerializedName(ABILITIES) val abilities: List<RemoteAbilities?>?,
    @SerializedName(BASE_EXPERIENCE) val baseexperience: Int?,
    @SerializedName(CRIES) val cries: RemoteCries?,
    @SerializedName(FORMS) val forms: List<RemotePokemon?>?,
    @SerializedName(GAME_INDICES) val gameindices: List<RemoteGameIndices?>?,
    @SerializedName(HEIGHT) val height: Int?,
    @SerializedName(HELD_ITEMS) val helditems: List<RemoteHeldItems?>?,
    @SerializedName(ID) val id: Int?,
    @SerializedName(IS_DEFAULT) val isdefault: Boolean?,
    @SerializedName(LOCATION_AREA_ENCOUNTERS) val locationareaencounters: String?,
    @SerializedName(MOVES) val moves: List<RemoteMoves?>?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(ORDER) val order: Int?,
    @SerializedName(SPECIES) val species: RemotePokemon?,
    @SerializedName(SPRITES) val sprites: RemoteSprites?,
    @SerializedName(STATS) val stats: List<RemoteStats?>?,
    @SerializedName(TYPES) val types: List<RemoteType?>?,
    @SerializedName(WEIGHT) val weight: Int?,

    )