package com.smithshodunke.cryptoapp.presentation.ui.coinlist

import com.smithshodunke.cryptoapp.domain.model.coin.Coin

data class CoinListViewState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = listOf(),
    val error: String? = null
)
