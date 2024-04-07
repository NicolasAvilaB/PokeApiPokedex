package com.pokemon.ui.pokeapipokedex.data.source

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.RemoteListSpritesPokemon

interface ListPokemonSourceRemote {
    suspend fun getListPokemonRemote(): RemoteListPokemon
    suspend fun getImagePokemonRemote(namePokemon: String): RemoteListSpritesPokemon
}
