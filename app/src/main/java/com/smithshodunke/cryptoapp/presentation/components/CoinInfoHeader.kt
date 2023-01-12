package com.smithshodunke.cryptoapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo
import com.smithshodunke.cryptoapp.presentation.theme.MediumDimension
import com.smithshodunke.cryptoapp.presentation.theme.SmallDimension

@Composable
fun CoinInfoHeader(
    modifier: Modifier = Modifier,
    coinInfo: CoinInfo
) {
    Row(
        modifier = Modifier.padding(MediumDimension),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.height(50.dp).width(50.dp),
            model = coinInfo.logo,
            contentDescription = "Crypto Coin Logo",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Column(modifier = Modifier.padding(SmallDimension)) {
            Text(text = "${coinInfo.name} (${coinInfo.symbol})", fontWeight = FontWeight.Bold)
            if (coinInfo.isActive) {
                Text(text = "active", color = Color.Green)
            } else {
                Text(text = "inactive", color = Color.Red)
            }
        }
    }
}