package com.pokemon.ui.pokeapipokedex.presentation.listpokemon

import com.pokemon.ui.pokeapipokedex.data.models.listpokemon.RemoteListPokemon

sealed class ListPokemonResult {
    sealed class GetListPokemonResult: ListPokemonResult(){
        object InProgress: GetListPokemonResult()
        object IsEmpty: GetListPokemonResult()
        data class Success(
            val listPokemon: RemoteListPokemon,
        ): GetListPokemonResult()
        data class Error(val error: Throwable): GetListPokemonResult()
    }
}