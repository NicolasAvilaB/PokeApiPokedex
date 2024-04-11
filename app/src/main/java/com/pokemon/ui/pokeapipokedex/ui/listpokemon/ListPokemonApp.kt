package com.pokemon.ui.pokeapipokedex.ui.listpokemon

import android.app.Application
import com.pokemon.ui.pokeapipokedex.di.DaggerPokemonComponent
import com.pokemon.ui.pokeapipokedex.di.PokemonComponent

class ListPokemonApp : Application() {
    val appComponent: PokemonComponent by lazy {
        DaggerPokemonComponent.factory().create(applicationContext)
    }
}
