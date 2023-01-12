package com.smithshodunke.cryptoapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.smithshodunke.cryptoapp.domain.model.coin.Coin
import com.smithshodunke.cryptoapp.presentation.theme.MediumDimension

@Composable
fun CoinListItem(
    coin: Coin,
    onClick: (coinId: String) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClick(coin.id) }
            .fillMaxWidth()
            .padding(MediumDimension),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.h1,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis
        )
        if (coin.isActive) {
            Text(text = "active", color = Color.Green)
        } else {
            Text(text = "inactive", color = Color.Red)
        }
    }
}