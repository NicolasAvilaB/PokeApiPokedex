package com.testlistdog.ui.listdogs.di

import androidx.fragment.app.FragmentActivity
import com.pokemon.ui.pokeapipokedex.data.PokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.PokemonRemoteImpl
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.PokemonWebService
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.Retrofit
import com.pokemon.ui.pokeapipokedex.data.source.PokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonProcessor
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonReducer
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

internal class ListPokemonProvider() {

    fun getIntentHandler() = ListPokemonIntentHandler()

    internal fun getViewModel(
        activity: FragmentActivity
    ): ListPokemonViewModel = getFactoryViewModel(
        activity = activity,
        reducer = getReducer(),
        processor = getProcessor()
    )

    private fun getReducer():
            ListPokemonReducer = ListPokemonReducer()

    private fun getProcessor():
            ListPokemonProcessor = ListPokemonProcessor(repository = getListPokemonRepository())

    private fun getListPokemonRepository():
            PokemonRepository = PokemonRepository(remote = getRemoteImpl())

    private fun getRemoteImpl():
            PokemonSourceRemote = PokemonRemoteImpl(webService = pokemonWebService)

    private val pokemonWebService: PokemonWebService
    init {
        val retrofit = Retrofit.provideRetrofit()
        pokemonWebService = retrofit.create(PokemonWebService::class.java)
    }
}