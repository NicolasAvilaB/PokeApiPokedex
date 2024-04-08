package com.pokemon.ui.pokeapipokedex.presentation

import com.pokemon.ui.pokeapipokedex.data.models.RemoteListPokemon

sealed class PokemonResult {
    sealed class GetListPokemonResult: PokemonResult(){
        object InProgress: GetListPokemonResult()
        object IsEmpty: GetListPokemonResult()
        data class Success(
            val listPokemon: RemoteListPokemon,
        ): GetListPokemonResult()
        data class Error(val error: Throwable): GetListPokemonResult()
    }
}