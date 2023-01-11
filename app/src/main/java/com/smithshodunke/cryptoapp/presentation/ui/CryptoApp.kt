package com.smithshodunke.cryptoapp.presentation.ui

import androidx.compose.runtime.Composable
import com.smithshodunke.cryptoapp.presentation.navigation.CryptoAppGraph
import com.smithshodunke.cryptoapp.presentation.theme.CryptoAppTheme

@Composable
fun CryptoApp() {
    CryptoAppTheme {
        CryptoAppGraph()
    }
}