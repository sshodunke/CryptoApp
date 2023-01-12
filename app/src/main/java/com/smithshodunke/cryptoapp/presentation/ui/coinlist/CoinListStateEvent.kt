package com.smithshodunke.cryptoapp.presentation.ui.coinlist

sealed class CoinListStateEvent {
    object RecallApi : CoinListStateEvent()
    class SortBy(val sort: Sorting) : CoinListStateEvent()

    enum class Sorting {
        ALPHABETICAL_ASC,
        ALPHABETICAL_DESC,
        RANK,
        DEFAULT,
        RANK_EXCLUDE_INACTIVE
    }

}

