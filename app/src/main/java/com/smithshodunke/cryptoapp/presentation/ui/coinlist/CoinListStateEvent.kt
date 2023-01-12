package com.smithshodunke.cryptoapp.presentation.ui.coinlist

sealed class CoinListStateEvent {
    object RecallApi : CoinListStateEvent()
}
