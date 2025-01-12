package com.pokemon.ui.pokeapipokedex.ui.listpokemon.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.items.ui.divider.ComposesHorizontalDivider
import com.items.ui.selectitemrow.ComposesMenuItem

@Composable
fun ListSelectItem(name: String, onClick: () -> Unit) {
    ComposesMenuItem(
        text = name.capitalize(),
        onClick = onClick
    )
    ComposesHorizontalDivider(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )
    )
}
