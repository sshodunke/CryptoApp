package com.smithshodunke.cryptoapp.presentation.ui.coininfo

import com.smithshodunke.cryptoapp.domain.model.coininfo.CoinInfo

data class CoinInfoViewState(
    val coinId: String,
    val isLoading: Boolean = false,
    val error: String? = null,
    val coinInfo: CoinInfo? = null
)
