package com.testlistdog.ui.listdogs.di

import androidx.fragment.app.FragmentActivity
import com.pokemon.ui.pokeapipokedex.data.ListPokemonRepository
import com.pokemon.ui.pokeapipokedex.data.remote.ListPokemonRemoteImpl
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.ListPokemonWebService
import com.pokemon.ui.pokeapipokedex.data.remote.retrofit.Retrofit
import com.pokemon.ui.pokeapipokedex.data.source.ListPokemonSourceRemote
import com.pokemon.ui.pokeapipokedex.presentation.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler

internal class ListPokemonProvider() {

    fun getIntentHandler() = ListPokemonIntentHandler()

    internal fun getViewModel(
        activity: FragmentActivity
    ): ListPokemonViewModel = getFactoryViewModel(
        activity = activity,
        repository = getListPokemonRepository()
    )

    private fun getListPokemonRepository():
            ListPokemonRepository = ListPokemonRepository(remote = getRemoteImpl())

    private fun getRemoteImpl():
            ListPokemonSourceRemote = ListPokemonRemoteImpl(webService = listPokemonWebService)

    private val listPokemonWebService: ListPokemonWebService
    init {
        val retrofit = Retrofit.provideRetrofit()
        listPokemonWebService = retrofit.create(ListPokemonWebService::class.java)
    }
}