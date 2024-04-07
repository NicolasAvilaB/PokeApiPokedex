package com.pokemon.ui.pokeapipokedex.presentation

import com.pokemon.ui.pokeapipokedex.data.ListPokemonRepository
import com.pokemon.ui.pokeapipokedex.data.source.ListPokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.PokemonAction.GetListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.PokemonResult.GetListPokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class PokemonProcessor(
    private val repository : ListPokemonRepository
) {
    fun actionProcessor(actions: PokemonAction): Flow<GetListPokemonResult> =
        when (actions) {
            is GetListPokemonAction -> getListPokemonProcessor()
        }

    private fun getListPokemonProcessor(): Flow<GetListPokemonResult> =
        repository.getListsPokemon()
            .map { remoteLogin ->
                GetListPokemonResult.Success(remoteLogin)
            }
            .onStart {
                GetListPokemonResult.InProgress
            }
            .catch {
                GetListPokemonResult.Error
            }
            .flowOn(Dispatchers.IO)
}