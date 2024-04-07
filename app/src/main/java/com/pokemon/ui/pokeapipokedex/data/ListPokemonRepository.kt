package com.pokemon.ui.pokeapipokedex.data

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.source.ListPokemonSourceRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListPokemonRepository(
    private val remote: ListPokemonSourceRemote
) {
    fun getListsPokemon(): Flow<RemoteListPokemon> = flow {
        val listDog = remote.getListPokemonRemote()
        emit(listDog)
    }
}