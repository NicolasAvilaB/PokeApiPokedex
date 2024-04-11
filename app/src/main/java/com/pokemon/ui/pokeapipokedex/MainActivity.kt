package com.pokemon.ui.pokeapipokedex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pokemon.ui.pokeapipokedex.presentation.detailpokemon.DetailPokemonViewModel
import com.pokemon.ui.pokeapipokedex.presentation.listpokemon.ListPokemonViewModel
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.DetailPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonApp
import com.pokemon.ui.pokeapipokedex.ui.listpokemon.ListPokemonIntentHandler
import com.pokemon.ui.pokeapipokedex.ui.theme.PokeApiPokedexTheme
import com.testlistdog.ui.navigation.NavController
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    @Inject
    lateinit var listPokemonViewModel: ListPokemonViewModel

    @Inject
    lateinit var listPokemonIntentHandler: ListPokemonIntentHandler

    @Inject
    lateinit var detailPokemonViewModel: DetailPokemonViewModel

    @Inject
    lateinit var detailPokemonIntentHandler: DetailPokemonIntentHandler

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as ListPokemonApp).appComponent.inject(this)

        setContent {
            PokeApiPokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavController(
                        listPokemonViewModel = listPokemonViewModel,
                        listPokemonIntentHandler = listPokemonIntentHandler,
                        detailPokemonViewModel = detailPokemonViewModel,
                        detailPokemonIntentHandler = detailPokemonIntentHandler
                    )
                }
            }
        }
    }
}
