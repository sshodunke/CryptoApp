package com.smithshodunke.cryptoapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.smithshodunke.cryptoapp.presentation.theme.MediumDimension

@Composable
fun CoinInfoTag(tag: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black
            )
            .padding(MediumDimension)
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.button,
            fontSize = MaterialTheme.typography.button.fontSize,
            textAlign = TextAlign.Center
        )
    }
}