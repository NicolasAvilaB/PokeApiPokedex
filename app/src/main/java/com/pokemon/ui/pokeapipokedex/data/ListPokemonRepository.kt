package com.pokemon.ui.pokeapipokedex.data

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailscreen.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.data.source.ListPokemonSourceRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListPokemonRepository(
    private val remote: ListPokemonSourceRemote
) {
    fun getListsPokemon(page: Int): Flow<RemoteListPokemon> = flow {
        val listPokemon = remote.getListPokemonRemote(page)
        emit(listPokemon)
    }

    fun getImagePokemon(namePokemon: String): Flow<RemoteListDetailPokemon> =
        flow {
            val imagePokemon = remote.getImagePokemonRemote(namePokemon)
            emit(imagePokemon)
        }
}