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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(0.8f),
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.h1,
            fontSize = 22.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            softWrap = true
        )
        if (coin.isActive) {
            Text(
                text = "active",
                color = Color.Green,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(0.2f),
                overflow = TextOverflow.Clip
            )
        } else {
            Text(
                text = "inactive",
                color = Color.Red,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(0.2f),
            )
        }
    }
}