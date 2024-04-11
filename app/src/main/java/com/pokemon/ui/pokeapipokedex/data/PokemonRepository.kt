package com.pokemon.ui.pokeapipokedex.data

import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val remote: PokemonSourceRemote
) {
    fun getListsPokemon(page: Int): Flow<RemoteListPokemon> = flow {
        val listPokemon = remote.getListPokemonRemote(page)
        emit(listPokemon)
    }

    fun getDetailPokemon(namePokemon: String): Flow<RemoteListDetailPokemon> =
        flow {
            val detailPokemon = remote.getDetailPokemonRemote(namePokemon)
            emit(detailPokemon)
        }
}