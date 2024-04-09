package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.viewstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.AttacksLearn
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.DataPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.GameIndex
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.HeaderAbility
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.HeaderImage
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.StatsBase
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.TypeTable

@Composable
fun DetailPokemonState(
    detailPokemon: RemoteListDetailPokemon,
    paddingValues: PaddingValues
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(scrollState)
            .fillMaxSize()

    ) {
        Row(modifier = Modifier.height(210.dp)) {
            HeaderImage(
                detailPokemon = detailPokemon,
                paddingText = paddingText
            )
            HeaderAbility(
                detailPokemon = detailPokemon,
                paddingText = paddingText
            )

        }
        Row(modifier = Modifier.height(310.dp)) {
            GameIndex(
                detailPokemon = detailPokemon,
                paddingText = paddingText
            )
            Column {
                DataPokemon(
                    detailPokemon = detailPokemon,
                    paddingText = paddingText
                )
                TypeTable(
                    detailPokemon = detailPokemon,
                    paddingText = paddingText
                )
            }
        }
        Row(
            modifier = Modifier.height(200.dp)
        ) {
            StatsBase(
                detailPokemon = detailPokemon,
                paddingText = paddingText
            )
            AttacksLearn(
                detailPokemon = detailPokemon,
                paddingText = paddingText
            )
        }
    }
}

private val paddingText = 6.dp