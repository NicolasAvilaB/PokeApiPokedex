package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListSelectItem(name: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(paddingRow)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = name.capitalize(),
            fontSize = 20.sp,
        )
    }
    Divider(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )
    )
}

private val paddingRow = 16.dp