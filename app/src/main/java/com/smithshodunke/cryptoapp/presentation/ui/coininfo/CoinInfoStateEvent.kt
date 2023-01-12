package com.smithshodunke.cryptoapp.presentation.ui.coininfo

sealed class CoinInfoStateEvent {
    object RecallApi : CoinInfoStateEvent()
}
