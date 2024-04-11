package com.pokemon.ui.pokeapipokedex.presentation.listpokemon

import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction.GetListPokemonAction
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonResult.GetListPokemonResult
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.events.ListPokemonAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class ListPokemonProcessor(
    private val repository : PokemonRepository
) {
    fun actionProcessor(actions: ListPokemonAction): Flow<GetListPokemonResult> =
        when (actions) {
            is GetListPokemonAction ->
                getListPokemonProcessor(
                    number = actions.number
                )
        }

    private fun getListPokemonProcessor(number: Int): Flow<GetListPokemonResult> =
        repository.getListsPokemon(page = number)
            .map { listPokemon ->
                if (listPokemon.results?.isEmpty() == true) {
                    GetListPokemonResult.IsEmpty
                }else {
                    GetListPokemonResult.Success(listPokemon)
                }
            }
            .onStart {
                emit(GetListPokemonResult.InProgress)
            }
            .catch { e ->
                emit(GetListPokemonResult.Error(e))
            }
            .flowOn(Dispatchers.IO)
            .distinctUntilChanged()
}