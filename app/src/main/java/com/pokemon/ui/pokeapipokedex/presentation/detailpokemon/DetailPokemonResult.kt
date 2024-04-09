package com.pokemon.ui.pokeapipokedex.presentation.detailpokemon

import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon

sealed class DetailPokemonResult {
    sealed class GetDetailPokemonResult : DetailPokemonResult() {
        object InProgress : GetDetailPokemonResult()
        object IsEmpty : GetDetailPokemonResult()
        data class Success(
            val detailPokemon: RemoteListDetailPokemon,
        ) : GetDetailPokemonResult()

        data class Error(val error: Throwable) : GetDetailPokemonResult()
    }
}
