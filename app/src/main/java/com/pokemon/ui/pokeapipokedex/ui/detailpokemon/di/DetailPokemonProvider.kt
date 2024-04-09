package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.di

import androidx.fragment.app.FragmentActivity
import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.PokemonRemoteImpl
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.PokemonWebService
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.Retrofit
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonReducer
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonIntentHandler

internal class DetailPokemonProvider {
    fun getIntentHandler() = DetailPokemonIntentHandler()

    internal fun getViewModel(
        activity: FragmentActivity
    ): DetailPokemonViewModel = getDetailFactoryViewModel(
        activity = activity,
        reducer = getReducer(),
        processor = getProcessor()
    )

    private fun getReducer():
            DetailPokemonReducer = DetailPokemonReducer()

    private fun getProcessor():
            DetailPokemonProcessor =
        DetailPokemonProcessor(
            repository = getDetailPokemonRepository()
        )

    private fun getDetailPokemonRepository():
            PokemonRepository =
        PokemonRepository(
            remote = getRemoteImpl()
        )

    private fun getRemoteImpl():
            PokemonSourceRemote =
        PokemonRemoteImpl(
            webService = pokemonWebService
        )

    private val pokemonWebService: PokemonWebService
    init {
        val retrofit = Retrofit.provideRetrofit()
        pokemonWebService = retrofit.create(PokemonWebService::class.java)
    }
}