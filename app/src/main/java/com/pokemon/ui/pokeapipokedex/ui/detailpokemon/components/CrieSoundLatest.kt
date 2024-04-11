package com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.pokemon.ui.pokeapipokedex.R
import com.pokemon.ui.pokeapipokedex.data.models.detailpokemon.RemoteListDetailPokemon
import com.pokemon.ui.pokeapipokedex.ui.detailpokemon.components.text.PokemonText16
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CrieSoundLatest(
    detailPokemon: RemoteListDetailPokemon,
    paddingText: Dp
) {
    Button(
        onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                val soundLatest = detailPokemon.cries?.latest
                runCatching {
                    MediaPlayer().apply {
                        reset()
                        setDataSource(soundLatest)
                        prepare()
                        start()
                        setOnCompletionListener {
                            release()
                        }
                    }
                }.onFailure { e ->
                    e.printStackTrace()
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = paddingText,
                end = paddingText
            )
    ) {
        PokemonText16(text = stringResource(id = R.string.crie_latest))
    }
}